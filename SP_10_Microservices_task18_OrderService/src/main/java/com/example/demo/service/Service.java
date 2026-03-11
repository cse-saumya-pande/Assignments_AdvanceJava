package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.netflix.discovery.converters.Auto;

public interface Service {
	
	Order createOrder(Order order);
	List<Order> getAllOrders();
	Order getOrderById(long id);
	
}
