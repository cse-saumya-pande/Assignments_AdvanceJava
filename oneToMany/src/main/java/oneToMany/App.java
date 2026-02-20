package oneToMany;

import java.util.Arrays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		// Create EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToManyMappingInHibernate");

		// Create EntityManager
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			// CREATE (INSERT)

			Account account1 = new Account("ACC786");
			Account account2 = new Account("ACC952");
			Customer customer1 = new Customer("John", Arrays.asList(account1, account2));
			em.persist(customer1);
			
			Account account3 = new Account("ACC648");
			Account account4 = new Account("ACC845");
			Customer customer2 = new Customer("Charlie", Arrays.asList(account3, account4));
			em.persist(customer2);
			
			Account account5 = new Account("ACC755");
			Account account6 = new Account("ACC998");
			Customer customer3 = new Customer("Harry", Arrays.asList(account5, account6));
			em.persist(customer3);


			// READ (FIND)
			Customer foundCustomer = em.find(Customer.class, 2);

			System.out.println("Found Customer: " + foundCustomer);

//			// UPDATE
//			if (foundCustomer != null) {
//				Account newAccount = new Account("ACC278");
//				foundCustomer.setAccountNumber(newAccount);
//
//				em.merge(foundCustomer);
//
//				System.out.println("Updated Customer: " + foundCustomer);
//			}

			// DELETE
			Customer customerToDelete = em.find(Customer.class, 5);

			if (customerToDelete != null) {
				em.remove(customerToDelete);
				System.out.println("Deleted Customer: " + customerToDelete);

			} else {
				System.out.println("Customer not found");
			}

			em.getTransaction().commit();

			System.out.println("Customer and Account saved Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
