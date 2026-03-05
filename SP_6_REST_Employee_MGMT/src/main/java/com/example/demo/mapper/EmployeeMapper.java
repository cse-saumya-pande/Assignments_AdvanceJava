package com.example.demo.mapper;

import com.example.demo.dto.DepartmentResponseDTO;
import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;

public class EmployeeMapper {
	public static Employee toEntity(EmployeeRequestDTO dto, Department department) {
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setSalary(dto.getSalary());
		employee.setDepartment(department);
		employee.setEmail(dto.getEmail());
		
		return employee;
	}
	
	public static EmployeeResponseDTO toResponseDTO(Employee employee) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		dto.setEmployeeId(employee.getEmployeeId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
		
        DepartmentResponseDTO deptDTO = new DepartmentResponseDTO();
        deptDTO.setId(employee.getDepartment().getId());
        deptDTO.setName(employee.getDepartment().getName());
        deptDTO.setLocation(employee.getDepartment().getLocation());

        dto.setDepartment(deptDTO);
        
        return dto;
	}
}
