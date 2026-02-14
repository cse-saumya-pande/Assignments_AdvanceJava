package main;

import entity.Passport;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App {

    public static void main(String[] args) {

        // Step 1: Load Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        Person person = new Person();
        person.setName("Ritika");
        person.setDob(new Date());

        Passport passport = new Passport();
        passport.setPassportNumber("IND12345");
        passport.setIssueDate(new Date());
        passport.setExpiryDate(new Date());

        person.setPassport(passport);
        passport.setPerson(person);

        session.persist(person);

        tx.commit();

        // Step 10: Close
        session.close();
        factory.close();

        System.out.println("Saved Successfully!");
    }
}
