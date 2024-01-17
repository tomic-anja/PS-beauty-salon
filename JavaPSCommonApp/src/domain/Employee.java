/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Dell E5450
 */
public class Employee implements Serializable {

    private Long employeeID;
    private String username;
    private String password;
    private String name;
    private String surname;

//    private Treatment treatment;
    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

//    public Treatment getTreatment() {
//        return treatment;
//    }
//
//    public void setTreatment(Treatment treatment) {
//        this.treatment = treatment;
//    }
    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + '}';
    }

}
