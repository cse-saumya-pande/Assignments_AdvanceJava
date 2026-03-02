package com.springrest.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.demo.model.Student;
import com.springrest.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Student> getStudentsByName(@PathVariable String name) {
		return ResponseEntity.ok(studentService.getStudentByName(name));
	}
	// PAGINATION ONLY
	@GetMapping("/paged")
	public ResponseEntity<List<Student>> getStudentsWithPagination(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {

	    return ResponseEntity.ok(
	            studentService.getStudentsWithPagination(page, size)
	    );
	}
	// SORTING ONLY
	@GetMapping("/sorted")
	public ResponseEntity<List<Student>> getStudentsSorted(
	        @RequestParam(defaultValue = "id") String sortBy,
	        @RequestParam(defaultValue = "asc") String direction) {

	    return ResponseEntity.ok(
	            studentService.getStudentsSorted(sortBy, direction)
	    );
	}

	@PostMapping
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		Student savedStudent = studentService.createStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(id, student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}
}