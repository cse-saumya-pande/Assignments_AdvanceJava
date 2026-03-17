package com.example.demo.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long orderId;
    private Long restaurantId;
    private Long productId;
    private Integer quantity;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderPlacedOn;
    private String eventType; // CREATED, UPDATED, CANCELLED
}