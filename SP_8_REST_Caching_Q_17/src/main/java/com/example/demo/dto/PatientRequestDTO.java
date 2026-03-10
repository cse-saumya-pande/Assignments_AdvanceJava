package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PatientRequestDTO {
	private String name;
	private int age;
	private long contactNumber;
	private String medicalHistory;
}
