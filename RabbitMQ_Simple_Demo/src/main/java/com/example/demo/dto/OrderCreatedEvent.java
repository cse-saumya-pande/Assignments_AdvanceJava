package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(
        String orderId,
        String customerId,
        BigDecimal totalAmount,
        Instant createdAt
) {}

