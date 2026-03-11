package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Order;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.OrderRepository;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service {
	@Autowired
	OrderRepository orderRepository;
	
	 @Autowired
	 private ProductClient productClient;

	 @Override
	 public Order createOrder(Order order) {

	        ProductDTO product = productClient.getProductById(order.getProductId());

	        if(product == null){
	            throw new RuntimeException("Product not found");
	        }
	        
	        Order order2 = new Order();
//	        order2.setOrderPlacedOnDateAndTime(LocalDateTime.now());
	        order2.setProductId(order.getProductId());
	        order2.setRestaurantId(order.getRestaurantId());
	        order2.setOrderPlacedOnDateAndTime(LocalDateTime.now());

	        return orderRepository.save(order);
	    }

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found by id : " + id));
	}

}
