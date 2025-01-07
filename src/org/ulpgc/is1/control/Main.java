package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

public class Main {
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();

        serviceManager.addCustomer("Matilda","López","123456789");
        serviceManager.addCustomer("Jesús","Quintana","987654321");

        serviceManager.addDevice("1234-1234",DeviceType.Tablet,serviceManager.getCustomers().get(0));
        serviceManager.addDevice("1234-5678",DeviceType.Mobile,serviceManager.getCustomers().get(0));
        serviceManager.addDevice("5678-1234",DeviceType.Laptop,serviceManager.getCustomers().get(1));

        serviceManager.addEmployee(1,"Julio","Pascual");
        serviceManager.addEmployee(2,"Pedro","García");

        serviceManager.service(0,1,ServiceType.Repair,"Reparación de la placa base",35,serviceManager.getEmployees().get(1));

        serviceManager.addTechnician(serviceManager.getDeviceServiceList(0,1).get(0),serviceManager.getEmployees().get(0),5,"Retirada de pantalla y revisión de componentes estropeados");
        serviceManager.addTechnician(serviceManager.getDeviceServiceList(0,1).get(0),serviceManager.getEmployees().get(1),2,"Revisión final y entrega de dispositivo");

        serviceManager.payService(serviceManager.getDeviceServiceList(0,1).get(0));


        System.out.println("************************************************");
        System.out.println("Cliente " + serviceManager.getCustomers().get(0).getName() + " " + serviceManager.getCustomers().get(0).getSurname() +
                " (Tlf.: " + serviceManager.getCustomers().get(0).getPhone().getNumber() + ")");
        System.out.println("************************************************\n");

        System.out.println("-------------------------------");
        System.out.println("       Servicio (ref." + serviceManager.getDeviceServiceList(0,1).get(0).getId() + ")");
        System.out.println("-------------------------------");
        System.out.println("*) Datos del servicio:");
        System.out.println("|- Ref.: " + serviceManager.getDeviceServiceList(0,1).get(0).getId());
        System.out.println("|- Descripción: " + serviceManager.getDeviceServiceList(0,1).get(0).getDescription());
        System.out.println("|- Tipo: Repair");
        if (serviceManager.getDeviceServiceList(0, 1).get(0).getPayment() == null) {
            System.out.println("|- Información del pago: No se ha realizado el pago\n");
        } else {
            System.out.println("|- Información del pago: Pago { fecha del pago= " +
                    serviceManager.getDeviceServiceList(0,1).get(0).getPayment().getDate() +
                    ", cantidad = " + serviceManager.getDeviceServiceList(0,1).get(0).getPayment().getAmount() + " euros }\n");
        }

        System.out.println("*) Datos del dispositivo:");
        System.out.println("|- Serial Number: " + serviceManager.getDevices().get(0).getSerialNumber());
        System.out.println("|- Tipo: " + serviceManager.getDevices().get(0).getDeviceType() + "\n");

        System.out.println("*) Datos del presupuesto:");
        System.out.println("|- Gestionado por: " + serviceManager.getDeviceServiceList(0,1).get(0).getBudget().getManager().getName() +
                " " + serviceManager.getDeviceServiceList(0,1).get(0).getBudget().getManager().getSurname());
        System.out.println("|- Fecha: " + serviceManager.getDeviceServiceList(0,1).get(0).getBudget().getDate());
        System.out.println("|- Total: " + serviceManager.getDeviceServiceList(0,1).get(0).getBudget().getAmount() + "\n");

        System.out.println("-------------------------------");
        System.out.println("   Tareas realizadas en el servicio");
        System.out.println("-------------------------------");
        for (Employee technician : serviceManager.getDeviceServiceList(0,1).get(0).getTechnicianList()) {
            System.out.println("Tarea { técnico = " + technician.getName() + " " + technician.getSurname() +
                    ", concepto = '" + technician.getWorkList().get(0).getDescription() + "', tiempo invertido = " + technician.getWorkList().get(0).getTimeSpent() + " }");
        }
    }
}
