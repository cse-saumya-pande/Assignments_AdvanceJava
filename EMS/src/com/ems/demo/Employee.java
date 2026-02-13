package com.ems.demo;

public class Employee {
	private int employeeId;
	private String name;
	private String department;
	private String designation;
	private double salary;
	private double yearsOfExperience;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String name, String department, String designation, double salary,
			double yearsOfExperience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	
}
