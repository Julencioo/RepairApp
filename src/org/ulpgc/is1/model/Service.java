package org.ulpgc.is1.model;
import java.time.LocalDate;
import java.util.ArrayList;


public class Service {
    private static int NEXT_ID = -1;
    private final int id;
    private ServiceType type;
    private String description;
    private Budget budget;
    private ArrayList<Employee> technicianList;
    private ArrayList<Work> workList;
    private Payment payment;

    public Service(ServiceType type, String description, int amount, Employee manager) {
        this.workList = new ArrayList<>();
        this.id = ++NEXT_ID;
        this.type = type;
        this.description = description;
        this.budget = new Budget(LocalDate.now(), amount, manager);
        this.technicianList = new ArrayList<>();
        this.payment = null;
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ArrayList<Employee> getTechnicianList() {
        return technicianList;
    }

    public void setTechnicianList(ArrayList<Employee> technicianList) {
        this.technicianList = technicianList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        if (payment != null) {
            throw new IllegalStateException("This service has already been payed");
        }
        this.payment = new Payment(LocalDate.now(), this.budget.getAmount());
    }

    public ArrayList<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(ArrayList<Work> workList) {
        this.workList = workList;
    }
}
