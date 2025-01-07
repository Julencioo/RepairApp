package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Objects;

public class Device {
    private String serialNumber;
    private DeviceType deviceType;
    private ArrayList<Service> deviceServiceList;
    private Customer owner;

    public Device(String serialNumber, DeviceType deviceType, Customer owner) {
        this.serialNumber = serialNumber;
        this.deviceType = deviceType;
        this.owner = owner;
        this.deviceServiceList = new ArrayList<>();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public ArrayList<Service> getDeviceServiceList() {
        return deviceServiceList;
    }

    public void setDeviceServiceList(ArrayList<Service> deviceServiceList) {
        this.deviceServiceList = deviceServiceList;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(this.serialNumber, device.serialNumber);
    }
}
