package com.springrest.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.demo.exception.StudentNotFoundException;
import com.springrest.demo.model.Student;
import com.springrest.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + name));
    }
    public List<Student> getStudentsWithPagination(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Student> studentPage = studentRepository.findAll(pageable);

        return studentPage.getContent();
    }
    public List<Student> getStudentsSorted(String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return studentRepository.findAll(sort);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setCity(student.getCity());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        studentRepository.delete(existingStudent);
    }
}