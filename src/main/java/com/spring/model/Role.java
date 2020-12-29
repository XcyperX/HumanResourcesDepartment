package com.spring.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("Администратор");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getNameRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    public static String getById(Long id) {
        for (Role role : values()) {
            if (role.ordinal() == id) {
                return role.getNameRole();
            }
        }
        return "UNKNOWN";
    }
}
