/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class Treatment implements Serializable {
    private int treatmentID;
    private TreatmentType treatmentType;
    private double price;
    
    private Client client;
    private List<Employee> employees; 
    private List<Appointment> appointments;

    public Treatment() {
    }

    public Treatment(int treatmentID, TreatmentType treatmentType, double price, Client client, List<Employee> employees, List<Appointment> appointments) {
        this.treatmentID = treatmentID;
        this.treatmentType = treatmentType;
        this.price = price;
        this.client = client;
        this.employees = employees;
        this.appointments = appointments;
    }

    public int getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    

}
