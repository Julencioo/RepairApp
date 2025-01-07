package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public Phone(String number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private boolean isValid(String number) {
        return number != null && number.matches("\\d{9}");
    }
}