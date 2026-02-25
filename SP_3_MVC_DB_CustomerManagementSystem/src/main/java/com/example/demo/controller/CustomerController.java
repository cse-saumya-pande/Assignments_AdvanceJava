package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	public CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String showCustomers(Model model) {
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customers", customerList);
	    return "customers";
	}
	
	@GetMapping("/addCustomer")
	public String showAddFormModel model() {
		
	}
}
