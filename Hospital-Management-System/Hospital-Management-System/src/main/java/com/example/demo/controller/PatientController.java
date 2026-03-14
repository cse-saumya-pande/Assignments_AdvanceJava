package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return service.save(patient);
    }

    @GetMapping
    public List<Patient> getPatients(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id){
        return service.get(id);
    }

}