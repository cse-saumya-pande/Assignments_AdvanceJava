package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sp3MvcProductTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp3MvcProductTaskApplication.class, args);
	}

}
