package com.example.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.demo.model.Employee;

public class EmployeeSpecification {

    // Filter by department
    public static Specification<Employee> hasDepartment(String department) {
        return (root, query, cb) ->
                cb.equal(root.get("department"), department);
    }

    // Salary >= minSalary
    public static Specification<Employee> salaryGreaterThanOrEqual(Double minSalary) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("salary"), minSalary);
    }

    // Salary <= maxSalary
    public static Specification<Employee> salaryLessThanOrEqual(Double maxSalary) {
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("salary"), maxSalary);
    }
}