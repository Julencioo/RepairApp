package org.ulpgc.is1.model;

import java.util.ArrayList;

public class ServiceManager {
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;
    private ArrayList<Device> devices;

    public ServiceManager() {
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.devices = new ArrayList<>();
    }

    public void addCustomer (String name, String surname, String phone) {
        Customer newCustomer = new Customer(name, surname, phone);
        if (!customers.contains(newCustomer)) {
            customers.add(newCustomer);
        }
    }

    public void addEmployee (int number, String name, String surname) {
        Employee newEmployee = new Employee(number, name, surname);
        if (!employees.contains(newEmployee)) {
            employees.add(newEmployee);
        }
    }

    public void addDevice (String serialNumber, DeviceType deviceType, Customer owner) {
        Device newDevice = new Device(serialNumber, deviceType, owner);
        if (!devices.contains(newDevice)) {
            devices.add(newDevice);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void service(int customerIndex, int deviceIndex, ServiceType type, String description, int amount, Employee manager) {
        if (customerIndex<0 || customerIndex>=customers.size()) {
            throw new IndexOutOfBoundsException("Customer index out of bounds");
        }
        else if (deviceIndex<0 || deviceIndex>=customers.get(customerIndex).getCustomerDeviceList().size()) {
            throw new IndexOutOfBoundsException("Device index out of bounds");
        }
        Device device = customers.get(customerIndex).getCustomerDeviceList().get(deviceIndex);
        Service newService = new Service(type, description, amount, manager);
        device.getServiceList().add(newService);
    }

    public void payService(Service service) {
        service.pay();
    }

    public ArrayList<Service> getDeviceServiceList (int customerIndex, int deviceIndex) {
        if (customerIndex<0 || customerIndex>=customers.size()) {
            throw new IndexOutOfBoundsException("Customer index out of bounds");
        }
        else if (deviceIndex<0 || deviceIndex>=customers.get(customerIndex).getCustomerDeviceList().size()) {
            throw new IndexOutOfBoundsException("Device index out of bounds");
        }
        return customers.get(customerIndex).getCustomerDeviceList().get(deviceIndex).getServiceList();
    }

    public void addTechnician(Service service, Employee technician, int timeSpent, String description) {
        if (!service.getTechnicianList().contains(technician)) {
            service.getTechnicianList().add(technician);
        } else {
            System.out.println("Technician already in the service");
        }

        Work newWork = new Work(technician, service, timeSpent, description);
        service.getWorkList().add(newWork);
        technician.getWorkList().add(newWork);
    }

    public ArrayList<Employee> getTechnician(Service service) {
        return service.getTechnicianList();
    }
}
