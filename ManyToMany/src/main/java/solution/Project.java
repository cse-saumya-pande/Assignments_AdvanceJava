package solution;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees;
	
	public Project() {
		super();
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}
	
	
	
}
