package com.example.demo.producer;

import com.example.demo.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public OrderEventProducer(
            RabbitTemplate rabbitTemplate,
            @Value("${app.rabbit.exchange}") String exchange,
            @Value("${app.rabbit.routing-key}") String routingKey
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void sendOrderCreated(OrderCreatedEvent event) {
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }
}

