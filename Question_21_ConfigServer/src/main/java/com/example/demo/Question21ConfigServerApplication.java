package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Question21ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Question21ConfigServerApplication.class, args);
	}

}
