package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DoctorRequestDTO {
	private String name;
	private String specialization;
	private String department;
}
