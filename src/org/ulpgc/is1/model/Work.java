package org.ulpgc.is1.model;

public class Work {
    private Employee technician;
    private Service service;
    private int timeSpent;
    private String description;

    public Work(Employee technician, Service service, int timeSpent, String description) {
        this.technician = technician;
        this.service = service;
        this.timeSpent = timeSpent;
        this.description = description;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getTechnician() {
        return technician;
    }

    public void setTechnician(Employee technician) {
        this.technician = technician;
    }
}
