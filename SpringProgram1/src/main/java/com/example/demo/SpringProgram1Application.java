package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringProgram1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProgram1Application.class, args);
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringProgram1Application.class, args);
		
		Payment payment = context.getBean(Payment.class);
        payment.pay();

        // Prototype Bean
        Payment upi1 = context.getBean(UpiPayment.class);
        Payment upi2 = context.getBean(UpiPayment.class);

        System.out.println(upi1);
        System.out.println(upi2);

        context.close();  
		
		
	}

}


