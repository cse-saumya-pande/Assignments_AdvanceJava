package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.model.Employee;

@Service
public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    public Page<EmployeeResponseDTO> getAllEmployees(
            Integer departmentId,
            Double minSal,
            Double maxSal,
            int page,
            int size,
            String dir);

    EmployeeResponseDTO getEmployeeById(Integer id);

    EmployeeResponseDTO updateEmployee(Integer id, EmployeeRequestDTO dto);

    void deleteEmployee(Integer id);
}