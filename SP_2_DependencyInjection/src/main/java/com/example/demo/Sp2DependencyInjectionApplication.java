package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sp2DependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp2DependencyInjectionApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(Sp2DependencyInjectionApplication.class, args);
		
		Car car = context.getBean(Car.class);
		car.drive();
	}

}
