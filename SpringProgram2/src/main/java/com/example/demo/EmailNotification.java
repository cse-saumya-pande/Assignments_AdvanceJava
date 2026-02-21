package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("email bean")
public class EmailNotification implements Notification{
	public EmailNotification() {
		System.out.println("Email Notification bean created . . . ");
	}
	
	@Override
	public void send(String s) {
		System.out.println("EMAIL Notification sent: "  + s);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Email Notification Bean Initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("EmailNotification Bean Destroyed");
	}
}
