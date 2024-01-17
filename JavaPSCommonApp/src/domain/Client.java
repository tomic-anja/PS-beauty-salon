/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class Client extends DomainObject implements Serializable {

    private int clientID;
    private String name;
    private String surname;
    private Long phoneNumber;

//    private List<Appointment> appointments = new ArrayList<>();
    public Client() {
    }

    public Client(int clientID, String name, String surname, Long phoneNumber, List<Appointment> appointments) {
        this.clientID = clientID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
//        this.appointments = appointments;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public List<Appointment> getAppointment() {
//        return appointments;
//    }
//
//    public void setAppointment(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnsForInsert() {
        return "name, surname, phoneNumber";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setLong(3, client.getPhoneNumber());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setClientID(primaryKey);
    }

    @Override
    public String getParamsForUpdate() {
        return "name=?, surname=?, phoneNumber=?  WHERE clientID = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setLong(3, client.getPhoneNumber());
            statement.setInt(4, client.getClientID());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setInt(1, client.getClientID());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }
}
