package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	public Car() {
		System.out.println("Car has been created by Spring!!");
	}
	@Override
	public void run() {
		System.out.println("Car running ... ");
	}
}
