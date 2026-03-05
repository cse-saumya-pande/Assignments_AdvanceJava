package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {
	private String firstName;
	private String lastName;
	private String email;
	private double salary;
	
	private int departmentId;	
}
