package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {
	private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;

    private DepartmentResponseDTO department;
}
