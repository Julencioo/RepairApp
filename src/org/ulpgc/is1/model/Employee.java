package org.ulpgc.is1.model;

import java.util.ArrayList;

public class Employee {
    private final int number;
    private String name;
    private String surname;
    private ArrayList<Work> workList;


    public Employee(int number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.workList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(ArrayList<Work> workList) {
        this.workList = workList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.number == employee.number;
    }
}
