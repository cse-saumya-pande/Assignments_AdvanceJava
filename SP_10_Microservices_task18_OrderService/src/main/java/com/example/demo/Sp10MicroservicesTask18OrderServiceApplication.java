package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Sp10MicroservicesTask18OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp10MicroservicesTask18OrderServiceApplication.class, args);
	}

}
