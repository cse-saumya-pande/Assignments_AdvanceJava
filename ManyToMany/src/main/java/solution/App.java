package solution;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	Project p1 = new Project("Insurance System");
	Project p2 = new Project("Tax system");
	Set<Project> projectSet = new HashSet<>();
	projectSet.add(p1);
	projectSet.add(p2);
	
	Employee e1 = new Employee("nox");
	Employee e2 = new Employee("glinda");
	Set <Employee> employeementSet = new HashSet<>();
	employeementSet.add(e1);
	employeementSet.add(e2);
	
	
	
	
}
