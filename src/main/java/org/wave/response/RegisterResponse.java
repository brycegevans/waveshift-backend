package org.wave.response;

import java.time.LocalDateTime;

public class RegisterResponse {
    private long id;
    private String email;
    private String role;
    private LocalDateTime joinedAt;

    private String firstName;
    private String lastName;

    public RegisterResponse(long id, String email, String role, LocalDateTime joinedAt, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.joinedAt = joinedAt;
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

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
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
