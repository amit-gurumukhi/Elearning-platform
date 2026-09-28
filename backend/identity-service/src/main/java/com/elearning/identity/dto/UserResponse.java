package com.elearning.identity.dto;

import com.elearning.identity.entity.Role;
import com.elearning.identity.entity.User;
import com.elearning.identity.entity.UserStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String email;
    private UserStatus status;
    private Set<Role> roles;
    private LocalDateTime createdAt;

    public UserResponse(
            UUID id,
            String email,
            UserStatus status,
            Set<Role> roles,
            LocalDateTime createdAt) {

        this.id = id;
        this.email = email;
        this.status = status;
        this.roles = roles;
        this.createdAt = createdAt;
    }

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getStatus(),
                user.getRoles(),
                user.getCreatedAt()
        );
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}