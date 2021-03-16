package com.spring.model;

import java.io.Serializable;

public enum Status implements Serializable {
    ACCEPTED("Принят"),
    APPLICATION_SENT("Заявка отправлена"),
    DELIVERED("Доставляется"),
    ISSUED_BY("Выдан"),
    CANCELED("Отменен");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getNameStatus() {
        return status;
    }

    public static String getById(Long id) {
        for (Status status : values()) {
            if (status.ordinal() == id) {
                return status.getNameStatus();
            }
        }
        return "UNKNOWN";
    }
}
