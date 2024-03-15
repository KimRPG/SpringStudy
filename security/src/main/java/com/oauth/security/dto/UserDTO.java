package com.oauth.security.dto;

import lombok.Getter;
import lombok.Setter;


public class UserDTO {

    private String role;
    private String name;
    private String username;

    public String getRole() {
        return role;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
