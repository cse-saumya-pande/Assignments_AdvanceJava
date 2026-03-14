package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment book(Appointment appointment){
        appointment.setStatus("BOOKED");
        return repository.save(appointment);
    }

    public List<Appointment> getAll(){
        return repository.findAll();
    }

}