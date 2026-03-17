package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	//add
	@PostMapping
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
		return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
	}
	
	//view all
	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		return ResponseEntity.ok(restaurantService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getById(@PathVariable long id){
		return ResponseEntity.ok(restaurantService.getById(id));
	}
}
