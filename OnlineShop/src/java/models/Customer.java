package models;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int customerId;
    private String username;
    private String password;
    private String fullName;
    private String email;

    // Default no-arg constructor
    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    // Getters and setters (omitted for brevity)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
    }

    public void setPhone(String phone) {
    }

    public void setAddress(String address) {
    }
}
