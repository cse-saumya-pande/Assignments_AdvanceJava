package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.ws.rs.DefaultValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="order_info")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@CreationTimestamp
    private LocalDateTime orderPlacedOnDateAndTime;
	private int quantity;
    private double totalAmount = 0.0;
    @Enumerated
    private OrderStatus status;
    
    private Long restaurantId;

    private Long productId;
	
}
