package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine  {

	public DieselEngine() {
		super();
	}
	
	@Override
	public String getEngine() {
		return "Diesel Engine";
	}
}
