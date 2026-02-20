package solution;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"), 
	inverseJoinColumn = @JoinColumn(name = "project_id"));
	private Set<Project> projects;

	public Employee() {
		super();
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(String name, Set<Project> projects) {
		super();
		this.name = name;
		this.projects = projects;
	}
	
	
	
}
