package com.spring.model;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public enum Role implements GrantedAuthority, Serializable {
    ADMIN("Администратор"),
    PROVIDER("Поставщик"),
    SELLER("Продавец"),
    CUSTOMER("Покупатель"),
    STOREKEEPER("Кладовщик");

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
