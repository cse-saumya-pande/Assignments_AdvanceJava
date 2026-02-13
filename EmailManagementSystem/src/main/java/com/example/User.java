package com.example;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    // Collection Mapping
    @ElementCollection
    @CollectionTable(
        name = "user_emails",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "email")
    private Set<String> emails;

    // Getters & Setters

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}
