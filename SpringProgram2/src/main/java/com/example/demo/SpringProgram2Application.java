package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProgram2Application {

    private final SMSNotification SMSNotification;

    SpringProgram2Application(SMSNotification SMSNotification) {
        this.SMSNotification = SMSNotification;
    }

	public static void main(String[] args) {
//		SpringApplication.run(SpringProgram2Application.class, args);
		
		ApplicationContext context = SpringApplication.run(SpringProgram2Application.class, args);
		
		
		EmailNotification email = context.getBean(EmailNotification.class);
		email.send("I AM SO TIRED AHHHHH");
		
		SMSNotification sms = context.getBean(SMSNotification.class);
		sms.send("RECUSEEE PLEASE ");
	}
}