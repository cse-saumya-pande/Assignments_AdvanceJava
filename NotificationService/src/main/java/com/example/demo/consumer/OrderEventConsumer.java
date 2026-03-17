package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.event.OrderEvent;


@Service
public class OrderEventConsumer {

	@RabbitListener(queues = "${app.rabbit.queue:notification-queue}")
    public void consumeOrderEvent(OrderEvent event) {

        System.out.println("Received Order Event");

        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Product ID: " + event.getProductId());
        System.out.println("Restaurant ID: " + event.getRestaurantId());
        System.out.println("Quantity: " + event.getQuantity());
        System.out.println("Total Amount: " + event.getTotalAmount());
        System.out.println("Placed At: " + event.getOrderPlacedOn());

        System.out.println("Sending Email Notification...");
    }
}