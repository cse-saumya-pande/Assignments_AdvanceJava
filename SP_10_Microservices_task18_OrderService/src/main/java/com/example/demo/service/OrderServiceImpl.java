package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.event.OrderEvent;
import com.example.demo.feign.ProductClient;
import com.example.demo.feign.RestaurantClient;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.ProductDTO;
import com.example.demo.publisher.OrderEventPublisher;
import com.example.demo.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RestaurantClient restaurantClient;

    @Autowired
    private OrderEventPublisher orderEventPublisher;
    
    
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackCreateOrder")
    public Order createOrder(Order order) {
        RestaurantDTO restaurant = restaurantClient.getRestaurantById(order.getRestaurantId());
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not found");
        }

        ProductDTO product = productClient.getProductById(order.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        double total = product.getPrice() * order.getQuantity();
        order.setTotalAmount(total);
        order.setStatus(OrderStatus.CONFIRMED);
        Order saved = orderRepository.save(order);
        OrderEvent event = new OrderEvent(
            saved.getId(),
            saved.getRestaurantId(),
            saved.getProductId(),
            saved.getQuantity(),
            saved.getTotalAmount(),
            saved.getStatus().name(),
            saved.getOrderPlacedOnDateAndTime(),
            "CREATED"
        );
        orderEventPublisher.publishOrderEvent(event);
        return saved;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackViewOrder")
    public Order getOrderById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found by id: " + id));
    }

    public Order fallbackViewOrder(long id, Throwable ex) {
        Order order = new Order();
        order.setId(id);
        order.setTotalAmount(0.0);
        order.setQuantity(0);
        order.setRestaurantId(null);
        order.setProductId(null);
        return order;
    }

    public Order fallbackCreateOrder(Order order, Throwable ex) {
        // If downstream dependencies (product/restaurant) are unavailable, do not persist a "junk" order.
        // Let the controller return an error so the caller can retry.
        throw new RuntimeException("Cannot create order: dependent service unavailable", ex);
    }
}