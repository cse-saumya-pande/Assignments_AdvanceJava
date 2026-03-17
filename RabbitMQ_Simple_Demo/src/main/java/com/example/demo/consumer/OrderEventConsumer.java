package com.example.demo.consumer;

import com.example.demo.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    @RabbitListener(queues = "${app.rabbit.queue}")
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.println("Received OrderCreatedEvent: " + event);
    }
}

