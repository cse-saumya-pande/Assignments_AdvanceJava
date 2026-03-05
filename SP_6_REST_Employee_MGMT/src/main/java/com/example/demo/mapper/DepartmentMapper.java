package com.example.demo.mapper;
import com.example.demo.dto.*;
import com.example.demo.model.Department;

public class DepartmentMapper {

    // Convert Request DTO → Entity
    public static Department toEntity(DepartmentRequestDTO dto) {

        Department department = new Department();
        department.setName(dto.getName());
        department.setLocation(dto.getLocation());

        return department;
    }

    // Convert Entity → Response DTO
    public static DepartmentResponseDTO toResponseDTO(Department department) {

        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());

        return dto;
    }
}