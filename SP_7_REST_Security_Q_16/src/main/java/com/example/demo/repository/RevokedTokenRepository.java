package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.RevokedToken;

public interface RevokedTokenRepository extends CrudRepository<RevokedToken, String>{

}
