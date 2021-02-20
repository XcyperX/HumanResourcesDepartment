package com.spring.model;

import java.io.Serializable;

public enum Gender implements Serializable {
    MALE("Мужской"),
    FEMALE("Женский");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getNameGender() {
        return gender;
    }

    public static String getById(Long id) {
        for (Gender gender : values()) {
            if (gender.ordinal() == id) {
                return gender.getNameGender();
            }
        }
        return "UNKNOWN";
    }
}
