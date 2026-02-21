package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component 
@Scope("prototype")
public class UpiPayment implements Payment{
	public UpiPayment() {
		System.out.println("UpiPayment Bean Created . . . ");
	}
	public void pay() {
		System.out.println("Pyament done via UPI . . . ");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("UPI bean initialized");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("UPI bean destroyed");
	}
}
