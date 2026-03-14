package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return service.save(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctors(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id){
        return service.getDoctor(id);
    }

}