package com.techm.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
	
public class CalculatorTest {
	private Calculator calc;
	
	@BeforeEach
	void setUp() {
		calc = new Calculator();
	}
	
	@Test
	public void testTwoAndTwoGivesFour() {
		assertEquals(4, calc.sum(2,2));
		assertEquals(4, calc.sum(2,2));
		assertEquals(4, calc.sum(2,2));
	}
	@Disabled
	public void testFiveAndFive() {
		assertEquals(2, calc.sum(6,5));
	}
	@RepeatedTest(3)
	@DisplayName("repeated test case")
	public void testFunc2() {
		assertEquals(10, calc.sum(5, 5), "the sum of 5 and 5 is equals");
	}
	
	@Nested
	@DisplayName("Nested class Subtraction tests)")
	class SubtractionTests{
		@Test
		@DisplayName("two numbers")
		public void subtractionOfTwo() {
			assertEquals(1, calc.subtract(5, 4), "5-4 = 1");
		}
		
		@Test
		public void subtractThree() {
		}
		
	}
	@ParameterizedTest
	@ValueSource (ints = {1,2,3,4,5})
	@DisplayName("test multiplication of numbers by 2")
	void testMultiplicationByTwo(int number) {
		assertEquals(number * 2, calc.mul(number ,2), "mumltiplication of 2 and 2");
	}
	
	@ParameterizedTest
	@CsvSource ({"2,2,4", "2,3,6", "4,4,16"})
	void testMultiply(int x, int y, int expected) {
		assertEquals(expected , calc.mul(x,y));
	}
	
	@ParameterizedTest
	@CsvFileSource (resources = "/csvCalc.csv", numLinesToSkip = 1)
	@DisplayName("Test sum using csv")
	void testSumUsingCSV(int a, int b, int expectedSum) {
		assertEquals(expectedSum, calc.sum(a,b));
	}
	
	@Test
	@DisplayName("test division by zero")
	void divisionByZero() {
		assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
	}
}
	