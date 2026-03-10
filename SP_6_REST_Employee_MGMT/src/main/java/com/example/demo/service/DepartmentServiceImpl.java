package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	//create
		public DepartmentResponseDTO createNewDepartment(DepartmentRequestDTO dto){
			Department department = new Department();
			department.setName(dto.getName());
			department.setLocation(dto.getLocation());
			
			Department departmentSaved = departmentRepository.save(department);
			
			return DepartmentMapper.toResponseDTO(departmentSaved);
		}

		//update
		public DepartmentResponseDTO editDepartment(int id, DepartmentRequestDTO dto){
			 Department existing = departmentRepository.findById(id)
			            .orElseThrow(() ->
			                    new ResourceNotFoundException("Department not found"));

			    existing.setName(dto.getName());
			    existing.setLocation(dto.getLocation());

			    Department updated = departmentRepository.save(existing);

			    return DepartmentMapper.toResponseDTO(updated);
		}

		
		//delete
		public void deleteDepartment(int id){
			Department department = departmentRepository.findById(id)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Department not found"));

//		    if (!department.getEmployees().isEmpty()) {
//		        throw new InvalidRequestException(
//		                "Cannot delete department with assigned employees");
//		    }

		    departmentRepository.delete(department);
		}

		//get ALl
		public List<DepartmentResponseDTO> getAllDepartments(){
			return departmentRepository.findAll()
		            .stream()
		            .map(DepartmentMapper::toResponseDTO)
		            .collect(Collectors.toList());
		}

		//get by id
		public DepartmentResponseDTO getDepartmentById(int id){
			Department department = departmentRepository.findById(id)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Department not found"));

		    return DepartmentMapper.toResponseDTO(department);
		}
}
