package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model) {

        List<Product> productList = productService.fetchProducts();

        model.addAttribute("products", productList);

        return "products";
    }
}