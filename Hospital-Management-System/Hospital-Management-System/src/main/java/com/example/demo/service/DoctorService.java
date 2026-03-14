package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor save(Doctor doctor){
        return repository.save(doctor);
    }

    @Cacheable("doctors")
    public Doctor getDoctor(Long id){
        return repository.findById(id).orElseThrow();
    }

    public List<Doctor> getAll(){
        return repository.findAll();
    }

}
