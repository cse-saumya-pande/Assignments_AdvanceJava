package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Appointment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PatientResponseDTO {
	private long id;
	private String name;
	private int age;
	private long contactNumber;
	private String medicalHistory;
	
	private List<Appointment> appointments;
	
}
