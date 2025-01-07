package org.ulpgc.is1.model;
import java.time.LocalDate;


public class Payment {
    private int amount;
    private LocalDate date;


    public Payment( LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
