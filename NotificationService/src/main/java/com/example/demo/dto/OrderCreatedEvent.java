package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {

	private Long orderId;
    private Long productId;
    private Long restaurantId;
    private int quantity;
    private double totalAmount;
    private LocalDateTime orderPlacedOnDateAndTime;
    
}