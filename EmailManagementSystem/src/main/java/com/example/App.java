package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        // Step 1: Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {

            // Step 3: Create User object
            User user = new User();
            user.setUsername("John");

            // Step 4: Create Set of Emails
            Set<String> emails = new HashSet<>();

            emails.add("john@gmail.com");
            emails.add("john.work@gmail.com");
            emails.add("john@yahoo.com");

            // Duplicate email (Set will ignore)
            emails.add("john@gmail.com");

            // Set emails to user
            user.setEmails(emails);

            // Step 5: Begin Transaction
            em.getTransaction().begin();

            // Step 6: Persist user
            em.persist(user);

            // Step 7: Commit Transaction
            em.getTransaction().commit();

            System.out.println("✅ User saved successfully!");

            // Step 8: Fetch User from DB
            User fetchedUser =
                    em.find(User.class, user.getUserId());

            // Step 9: Display Data
            System.out.println("\n📌 User Details");
            System.out.println("User ID   : " + fetchedUser.getUserId());
            System.out.println("Username  : " + fetchedUser.getUsername());

            System.out.println("Emails    : ");
            for (String email : fetchedUser.getEmails()) {
                System.out.println(" - " + email);
            }

        } finally {

            // Step 10: Close resources
            em.close();
            emf.close();
        }
    }
}
