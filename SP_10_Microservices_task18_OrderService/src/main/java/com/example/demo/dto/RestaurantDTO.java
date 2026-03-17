package com.example.demo.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private long id;
    private String name;
    private String address;
}