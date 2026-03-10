package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Appointment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DoctorResponseDTO {
	private long id;
	private String name;
	private String specialization;
	private String department;
	
	private List<Appointment> appointments;
	
}
