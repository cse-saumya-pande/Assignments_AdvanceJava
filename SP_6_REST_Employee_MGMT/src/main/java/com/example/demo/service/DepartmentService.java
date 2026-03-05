package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;

@Service
public interface DepartmentService {
	//create
	DepartmentResponseDTO createNewDepartment(DepartmentRequestDTO dto);
	//update
	DepartmentResponseDTO editDepartment(int id, DepartmentRequestDTO dto);
	
	//delete
	void deleteDepartment(int id);
	//get ALl
	List<DepartmentResponseDTO> getAllDepartments();
	//get by id
	DepartmentResponseDTO getDepartmentById(int id);
}