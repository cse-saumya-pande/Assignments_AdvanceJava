package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;
import com.example.demo.service.DepartmentServiceImpl;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
		return ResponseEntity.ok(departmentServiceImpl.getAllDepartments());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@RequestParam int id){
		return ResponseEntity.ok(departmentServiceImpl.getDepartmentById(id));
	}
	
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO dto){
		return ResponseEntity.ok(departmentServiceImpl.createNewDepartment(dto));
	}
	
}
