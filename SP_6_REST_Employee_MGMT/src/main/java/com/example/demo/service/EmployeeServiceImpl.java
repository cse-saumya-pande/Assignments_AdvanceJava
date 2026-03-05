package com.example.demo.service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Pageable; 
import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import jakarta.persistence.criteria.Predicate;
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		Department department = departmentRepository.findById(dto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		Employee employee = EmployeeMapper.toEntity(dto, department);

		Employee saved = employeeRepository.save(employee);

		return EmployeeMapper.toResponseDTO(saved);
	}

//	public List<EmployeeResponseDTO> getAllEmployees(String department, double minSal, double maxSal, ) {
//		return employeeRepository.findAll()
//				.stream()
//				.filter(null)
//				.map(EmployeeMapper::toResponseDTO)
//				.collect(Collectors.toList());
//	}
	
	public Page<EmployeeResponseDTO> getAllEmployees(
	        Integer departmentId,
	        Double minSal,
	        Double maxSal,
	        int page,
	        int size,
	        String dir) {

	    Specification<Employee> spec = (root, query, cb) -> {

	        List<Predicate> predicates = new ArrayList<>();

	        if (departmentId != null) {
	            predicates.add(
	                    cb.equal(root.get("department").get("id"), departmentId)
	            );
	        }

	        if (minSal != null) {
	            predicates.add(
	                    cb.greaterThanOrEqualTo(root.get("salary"), minSal)
	            );
	        }

	        if (maxSal != null) {
	            predicates.add(
	                    cb.lessThanOrEqualTo(root.get("salary"), maxSal)
	            );
	        }

	        return cb.and(predicates.toArray(new Predicate[0]));
	    };

	    Sort sort = dir.equalsIgnoreCase("ASC") ?
	            Sort.by("salary").ascending() :
	            Sort.by("salary").descending();

	    Pageable pageable = PageRequest.of(page, size, sort);

	    Page<Employee> employeePage =
	            employeeRepository.findAll(spec, pageable);

	    return employeePage.map(EmployeeMapper::toResponseDTO);
	}

	public EmployeeResponseDTO getEmployeeById(Integer id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find the employee by id : " + id));
		
		return EmployeeMapper.toResponseDTO(employee);
	}

	public EmployeeResponseDTO updateEmployee(Integer id, EmployeeRequestDTO dto) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find the employee by id : " + id));
		
		Department department = departmentRepository.findById(dto.getDepartmentId())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Department not found"));
		
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setSalary(dto.getSalary());
		employee.setDepartment(department);
		
		Employee updated = employeeRepository.save(employee);
		
		return EmployeeMapper.toResponseDTO(employee);
	}
	
	
	public void deleteEmployee(Integer id) {

	    if (!employeeRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Employee not found");
	    }

	    employeeRepository.deleteById(id);
	}
}
