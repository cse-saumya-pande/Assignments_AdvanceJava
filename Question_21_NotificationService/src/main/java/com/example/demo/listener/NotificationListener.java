package com.example.demo.listener;

import com.example.demo.dto.AppointmentCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @RabbitListener(queues = "appointment.queue")
    public void handleAppointmentCreatedEvent(AppointmentCreatedEvent event) {
        log.info("Received Appointment event -> Sending confirmation notification...");
        log.info("Patient Name: {}", event.getPatientName());
        log.info("Doctor: {}", event.getDoctorName());
        log.info("Date: {}", event.getAppointmentDate());
        log.info("Notification successfully sent to {}", event.getPatientName());
    }
}
