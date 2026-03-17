package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient save(Patient p){
        return repository.save(p);
    }

    public List<Patient> getAll(){
        return repository.findAll();
    }

    public Patient get(Long id){
        return repository.findById(id).orElseThrow();
    }

}