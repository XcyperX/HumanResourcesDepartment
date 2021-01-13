package com.spring.model;

public enum Payment {
    ONCE("Однократно в конце срока"),
    IN_PARTS("Частями по актам");

    private String payment;

    Payment(String payment) {
        this.payment = payment;
    }

    public String getNamePayment() {
        return payment;
    }

    public static String getById(Long id) {
        for (Payment payment : values()) {
            if (payment.ordinal() == id) {
                return payment.getNamePayment();
            }
        }
        return "UNKNOWN";
    }
}
