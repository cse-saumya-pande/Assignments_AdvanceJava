package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
@Primary
public class CreditCardPayment implements Payment {
	
	public CreditCardPayment() {
		System.out.println("CreditCardPayment Bean Created . . .");
	}
	
	@PreDestroy
    public void destroy() {
        System.out.println("CreditCardPayment Bean Destroyed");
    }
	public void pay() {
		System.out.println("Payment done via credit card . . . ");
	}
}
