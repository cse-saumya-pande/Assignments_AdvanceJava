package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component("sms bean")
@Lazy
@Primary
public class SMSNotification implements Notification{
	
	
	public SMSNotification() {
		// TODO Auto-generated constructor stub
		System.out.println("SmsNotification Bean Created");
	}
	
	@Override
	public void send(String s) {
		System.out.println("SMS Notification sent: " + s);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("SMS Notification Bean Initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("SMS Notification Bean Destroyed");
	}
}
