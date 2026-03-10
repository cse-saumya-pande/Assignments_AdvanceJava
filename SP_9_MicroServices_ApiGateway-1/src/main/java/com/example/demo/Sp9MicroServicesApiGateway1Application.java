package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sp9MicroServicesApiGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp9MicroServicesApiGateway1Application.class, args);
	}

}
