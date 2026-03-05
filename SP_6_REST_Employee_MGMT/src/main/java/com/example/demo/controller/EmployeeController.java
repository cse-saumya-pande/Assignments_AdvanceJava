package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> addEmployee(@PathVariable EmployeeRequestDTO dto){
		return ResponseEntity.ok(employeeServiceImpl.createEmployee(dto));
	}

    @GetMapping
    public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(

            @RequestParam(required = false) Integer departmentId,

            @RequestParam(required = false) Double minSal,

            @RequestParam(required = false) Double maxSal,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "ASC") String dir
    ) {

        Page<EmployeeResponseDTO> employees =
                employeeServiceImpl.getAllEmployees(
                        departmentId,
                        minSal,
                        maxSal,
                        page,
                        size,
                        dir
                );

        return ResponseEntity.ok(employees);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int id){
		return ResponseEntity.ok(employeeServiceImpl.getEmployeeById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> editEmployeeById(@PathVariable int id, @RequestBody EmployeeRequestDTO dto){
		return ResponseEntity.ok(employeeServiceImpl.updateEmployee(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
		employeeServiceImpl.deleteEmployee(id);
		
		return ResponseEntity.ok("Successfully deleted EmployeeById : " + id);
	}
	
}
