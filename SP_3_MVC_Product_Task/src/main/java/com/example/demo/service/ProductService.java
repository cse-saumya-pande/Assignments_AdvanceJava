package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductDAO;


@Service
public class ProductService {

    private ProductDAO productDAO;

    // Constructor Injection
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> fetchProducts() {
        return productDAO.getAllProducts();
    }
}