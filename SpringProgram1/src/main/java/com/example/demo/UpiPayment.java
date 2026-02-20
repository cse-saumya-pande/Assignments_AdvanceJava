package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class UpiPayment implements Payment{
	public UpiPayment() {
		System.out.println("UpiPayment Bean Created . . . ");
	}
	public void pay() {
		System.out.println("Pyament done via UPI . . . ");
	}
}
