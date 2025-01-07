package org.ulpgc.is1.model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private Phone phone;
    private ArrayList<Device> customerDeviceList;

    public Customer(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phone = new Phone(phoneNumber);
        this.customerDeviceList = new ArrayList<>();
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(String phoneNumber) {
        this.phone = new Phone(phoneNumber);
    }

    public ArrayList<Device> getCustomerDeviceList() {
        return customerDeviceList;
    }

    public void setCustomerDeviceList(ArrayList<Device> customerDeviceList) {
        this.customerDeviceList = customerDeviceList;
    }

    public void addDevice(Device device) {
        if (!customerDeviceList.contains(device)) {
            customerDeviceList.add(device);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return this.phone.getNumber().equals(customer.phone.getNumber());
    }


}


