package junitAssignment1Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junitAssignment1.Student;
import junitAssignment1.StudentService;

public class StudentServiceTest {
	StudentService service;
	@BeforeEach
	void initializeStudent() {
		service = new StudentService();
	}
	@Test
	void checkTotal() {
		
	}
	@Test
	void checkAverage() {
		assertEquals(,,service.calculateAverage(new Student()));
	}
	@Test
	void checkPassedFalse() {
		assertFalse(service.isPassing( new Student()));
	}
	@Test
	void checkPassedTrue() {
		assertTrue(service.isPassing( new Student()));
	}
}
