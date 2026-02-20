package manyToOne;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        // Step 1: Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ManyToOnePU");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Step 3: Begin Transaction
        em.getTransaction().begin();

        // Step 4: Create Department
        Department dept = new Department();
        dept.setName("IT Department");

        // Save Department first
        em.persist(dept);

        // Step 5: Create Students
        Student s1 = new Student();
        s1.setName("Arya");
        s1.setDepartment(dept);

        Student s2 = new Student();
        s2.setName("Raj");
        s2.setDepartment(dept);

        // Step 6: Persist Students
        em.persist(s1);
        em.persist(s2);

        // Step 7: Commit Transaction
        em.getTransaction().commit();

        // Step 8: Close Resources
        em.close();
        emf.close();

        System.out.println("Data Inserted Successfully...");
    }
}