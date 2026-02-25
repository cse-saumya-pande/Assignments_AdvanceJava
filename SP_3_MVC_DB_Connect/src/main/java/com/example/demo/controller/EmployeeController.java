package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public String getEmployees(Model model) {
	    List<Employee> employees = employeeService.getAllEmployees();
	    System.out.println("SIZE = " + employees.size());
	    model.addAttribute("employees", employees);
	    return "employee";
	}
	
	@GetMapping("/employees")
	public ModelAndView getEmployeeDetails() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employees);
		mv.setViewName("employee");
		return mv;
	}
	
	@GetMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
}
