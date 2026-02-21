package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine{

	public PetrolEngine() {
		super();
		System.out.println("Petrol Engine Bean Created By Spring . . .");
	}
	
	@Override
	public String getEngine() {
		return "Petrol Engine";
	}
}
