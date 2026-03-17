package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentCreatedEvent {
    private Long appointmentId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private LocalDateTime appointmentDate;
}
