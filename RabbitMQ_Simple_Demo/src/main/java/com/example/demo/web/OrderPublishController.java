package com.example.demo.web;

import com.example.demo.dto.OrderCreatedEvent;
import com.example.demo.producer.OrderEventProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderPublishController {
    private final OrderEventProducer producer;

    public OrderPublishController(OrderEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<OrderCreatedEvent> publish(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) BigDecimal totalAmount
    ) {
        OrderCreatedEvent event = new OrderCreatedEvent(
                UUID.randomUUID().toString(),
                customerId != null ? customerId : "cust-123",
                totalAmount != null ? totalAmount : new BigDecimal("99.99"),
                Instant.now()
        );
        producer.sendOrderCreated(event);
        return ResponseEntity.ok(event);
    }
}

