package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.feign.ProductClient;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service {
	@Autowired
	OrderRepository orderRepository;
	
	 @Autowired
	 private ProductClient productClient;
	 
	 @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackCreateOrder")
	 public Order createOrder(Order order) {
	     ProductDTO product = productClient.getProductById(order.getProductId());
	     
	     if(product == null){
	            throw new RuntimeException("Product not found");
	        }
	     
	     double total = product.getPrice() * order.getQuantity();

	     order.setTotalAmount(total);
	     order.setStatus(OrderStatus.CONFIRMED);

	     return orderRepository.save(order);
	 }

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	
	@CircuitBreaker(name="product-service", fallbackMethod="fallbackViewOrder")
	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found by id : " + id));
	}
	
	//fallback method
	public Order fallbackViewOrder(long id, Exception ex) {

	    Order order = new Order();
	    order.setId(id);
	    order.setTotalAmount(0.0);
	    order.setQuantity(0);
	    order.setRestaurantId(null);
	    order.setProductId(null);

	    return order;
	}
	
	public Order fallbackCreateOrder(Order order, Exception ex) {

	    order.setTotalAmount(0.0);
	    order.setStatus(OrderStatus.PENDING);

	    return orderRepository.save(order);
	}

}