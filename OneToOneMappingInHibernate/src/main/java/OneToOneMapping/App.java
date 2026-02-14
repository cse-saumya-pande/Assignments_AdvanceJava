package OneToOneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        // Step 1: Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("OneToOneMappingInHibernate");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Step 3: Begin Transaction
        em.getTransaction().begin();

        // Step 4: Create Account
        Account account = new Account("ACC12345", "Savings");

        // Step 5: Create Customer
        Customer customer = new Customer();
        customer.setName("Ritika");

        // 🔗 Unidirectional Link (Only one side)
        customer.setAccount(account);

        // Step 6: Persist Customer
        // CascadeType.ALL → Account auto-saved
        em.persist(customer);

        // Step 7: Commit
        em.getTransaction().commit();

        // Step 8: Close
        em.close();
        emf.close();

        System.out.println("Data inserted successfully...");
    }
}
