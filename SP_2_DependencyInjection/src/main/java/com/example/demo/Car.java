package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Car {

    private final PetrolEngine petrolEngine;
	private Engine engine;

	@Autowired
	public Car(Engine engine, PetrolEngine petrolEngine) {
		super();
		this.engine = engine;
		System.out.println("Car bean created by Spring . . . ");
		this.petrolEngine = petrolEngine;
	}
	
	public void drive() {
		System.out.println("Car is driving using " + engine.getEngine());
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Car has been initialized");
	}
}
