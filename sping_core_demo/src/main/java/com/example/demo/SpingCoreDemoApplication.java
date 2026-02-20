package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ReactiveAdapterRegistry.SpringCoreBlockHoundIntegration;

@SpringBootApplication
public class SpingCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingCoreDemoApplication.class, args);
		System.out.println("Hello Words");
		
		ApplicationContext context = SpringApplication.run(SpingCoreDemoApplication.class, args);
		//Car car = new Car();
		Car car2 = context.getBean(Car.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
//		System.out.println(vehicle);
		vehicle.run();
	}

}
