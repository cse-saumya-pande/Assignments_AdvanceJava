package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentResponseDTO {
	private LocalDate date;
	private String location;
	private String status;
	private Patient patient;
	private Doctor doctor;
}
