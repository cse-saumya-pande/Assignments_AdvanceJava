package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;


@Repository
public class ProductDAO {

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        // Creating products inside DAO
        products.add(new Product(1, "Laptop", 75000));
        products.add(new Product(2, "Mobile", 25000));
        products.add(new Product(3, "Headphones", 3000));

        return products;
    }
}