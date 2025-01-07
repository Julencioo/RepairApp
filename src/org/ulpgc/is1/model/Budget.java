package org.ulpgc.is1.model;

import java.time.LocalDate;


public class Budget {
    private LocalDate date;
    private int amount;
    private Employee manager;

    public Budget(LocalDate date, int amount, Employee manager) {
        this.date = date;
        this.amount = amount;
        this.manager = manager;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
