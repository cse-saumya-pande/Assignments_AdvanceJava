package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Bike implements Vehicle {
	public Bike() {
		System.out.println("Bike created . . . ");
	}
	
	@Override
	public void run() {
		System.out.println("Bike running . . . ");
	}
	
}