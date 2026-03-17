package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantService {
	private final RestaurantRepository restaurantRepository;

	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	//add
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	//view all 
	public List<Restaurant> getAll(){
		return restaurantRepository.findAll();
	}
	
	///get by id
	public Restaurant getById(long id) {
		return restaurantRepository.findById(id).orElseThrow(()->new RuntimeException("restaurant not found by id : " + id));
	}
}
