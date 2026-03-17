package com.example.demo.service;

import com.example.demo.client.DoctorClient;
import com.example.demo.dto.AppointmentCreatedEvent;
import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE_NAME = "appointment.exchange";
    public static final String ROUTING_KEY = "appointment.created";

    public Appointment createAppointment(Appointment appointment) {
        // Validate doctor details using Feign Client
        DoctorDto doctor = doctorClient.getDoctorById(appointment.getDoctorId());
        
        if (doctor == null || !doctor.isAvailability()) {
            throw new RuntimeException("Doctor is not available or does not exist!");
        }

        // Set date if null
        if (appointment.getAppointmentDate() == null) {
            appointment.setAppointmentDate(LocalDateTime.now().plusDays(1)); // Tomorrow by default
        }

        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Create Event
        AppointmentCreatedEvent event = new AppointmentCreatedEvent(
                savedAppointment.getId(),
                savedAppointment.getPatientName(),
                doctor.getId(),
                doctor.getName(),
                savedAppointment.getAppointmentDate()
        );

        // Publish Event to RabbitMQ
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, event);

        return savedAppointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
