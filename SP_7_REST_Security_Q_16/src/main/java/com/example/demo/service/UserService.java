package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//add
	public User addUser(User user) {
		return userRepository.save(user);
	}
	//view
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	//viewById
	public User getById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by ID : " + id));
	}
	//delete
	public void deleteById(int id) {
		if(!userRepository.existsById(id))
			throw new RuntimeException("User not found by ID : " + id);
		userRepository.deleteById(id);
	}
}

