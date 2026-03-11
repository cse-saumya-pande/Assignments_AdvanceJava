package com.example.demo.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter
@RequiredArgsConstructor
public class ProductRequestDTO {

    private String name;
    private double price;
}