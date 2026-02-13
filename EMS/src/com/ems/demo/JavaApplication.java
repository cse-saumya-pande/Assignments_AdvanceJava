package com.ems.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaApplication {
	public static double findAvg(List<Employee> s) {
		return s.stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);
	}
	public static List<String> getHighestSalEmployee(List<Employee> s) {
		double maxSalary = s.stream()
				.mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);

		return s.stream()
				.filter(e -> e.getSalary() == maxSalary)
		    .map(Employee::getName)
		    .collect(Collectors.toList());
	}
	public static List<String> salAbove80k(List<Employee> s){
		return s.stream()
				.filter(e -> e.getSalary() > 80000.0)
				.map(Employee::getName)
				.collect(Collectors.toList());
	}
	public static Map<String, Integer> findDeptStrength(List<Employee> s){
		return s.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.counting(),
                        Long::intValue
                )
        ));
	}
	
	public static List<String> getITDeptPeopleMoreThan5YearsExp(List<Employee> s){
		return s.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
				.filter(e -> e.getYearsOfExperience() > 5.0)
				.map(Employee::getName)
				.collect(Collectors.toList());
	}
	
	public static void execution() {
		Employee e1 = new Employee(1, "Saumya", "SDE", "Dev", 2400000.0, 2.3);
		Employee e2 = new Employee(2, "Nox", "Test", "Tester", 1200000.0, 1.3);
		Employee e3 = new Employee(3, "Aldtrich", "IT", "Engineer", 4000000.0, 5.3);
		Employee e4 = new Employee(4, "Bob", "GameDev", "Dev", 1000000.0,  1.5);
		
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(e1);
		listOfEmployees.add(e2);
		listOfEmployees.add(e3);
		listOfEmployees.add(e4);
		
		System.out.println("Average salary : " + findAvg(listOfEmployees));
		for(String s : getHighestSalEmployee(listOfEmployees)) {
			System.out.print("Highest salary employee(s) : " + s);
		}
		System.out.println();
		
		System.out.print("IT Dept employees with more than 5 years experience: ");
	    getITDeptPeopleMoreThan5YearsExp(listOfEmployees)
	            .forEach(name -> System.out.print(name + " "));
		
	}
	
	public static void main(String[] args) {
		execution();
	}
}
