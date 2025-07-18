package org.wave.response;

import java.time.LocalDateTime;

public class UpdateResponse {
    private long id;
    private String email;
    private String role;
    private LocalDateTime lastUpdated;
    private String firstName;
    private String lastName;

    public UpdateResponse(long id, String email, String role, LocalDateTime lastUpdated, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.lastUpdated = lastUpdated;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
