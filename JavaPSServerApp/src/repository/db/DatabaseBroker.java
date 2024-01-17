/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import domain.Client;
import domain.DomainObject;
import domain.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cartman
 */
public class DatabaseBroker {

    private final Connection connection;

    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    public Employee getUser(Employee employee) throws SQLException {
        try {
            String query = "SELECT employeeID, username, password, name, surname FROM employee WHERE username=? AND password=?";
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement
                    = connection.prepareStatement(query);
            statement.setString(1, employee.getUsername());
            statement.setString(2, employee.getPassword());
            //izvsi upit
            ResultSet rs = statement.executeQuery();

            //pristup rezultatima upita
            if (rs.next()) {
                employee.setEmployeeID(rs.getLong("employeeID"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
            } else {
                employee = null;
            }
            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekta User iz baze!");
            return employee;
        } catch (SQLException ex) {
            System.out.println("Objekat User nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public void add(DomainObject domainObject) throws SQLException {
        try {
//            String query = "INSERT INTO person (firstname, lastname, birthday, city, gender, married) VALUES (?,?,?,?,?,?)";
            String query = "INSERT INTO " + domainObject.getTableName()
                    + " (" + domainObject.getColumnsForInsert() + ") VALUES " + domainObject.getParamsForInsert();

            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //postavljanje vrednosti parametara
            domainObject.setParamsForInsert(statement, domainObject);

            //izvsi upit
            int result = statement.executeUpdate();
            //System.out.println("Result = " + result);
            System.out.println("Objekat uspesno dodat u bazu!");

            //pristup generisanom kljucu
            if (domainObject.containsAutoIncrementPK()) {
                ResultSet rsID = statement.getGeneratedKeys();
                if (rsID.next()) {
                    //person.setPersonID(rsID.getLong(1));
                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
                }
                rsID.close();
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Client> getClients() {
        try {
            List<Client> clients = new ArrayList<>();
            String query = "SELECT * FROM client";
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            Statement statement = connection.createStatement();
            //izvsi upit
            ResultSet rs = statement.executeQuery(query);

            //pristup rezultatima upita
            while (rs.next()) {
                Client client = new Client();
                client.setClientID(rs.getInt("clientID"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setPhoneNumber(rs.getLong("phoneNumber"));

                clients.add(client);
            }
            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata Client iz baze!");
            return clients;
        } catch (SQLException ex) {
            System.out.println("Objekti Client nisu uspesno ucitani iz baze!");
        }
        return null;
    }

    public void update(DomainObject domainObject) throws SQLException {
        try {
            String query = "UPDATE " + domainObject.getTableName() + " SET " + domainObject.getParamsForUpdate();

            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //postavljanje vrednosti parametara
            domainObject.setParamsForUpdate(statement, domainObject);

            //izvsi upit
            int result = statement.executeUpdate();
            //System.out.println("Result = " + result);
            System.out.println("Objekat uspesno izmenje u bazi!");

            //pristup generisanom kljucu
//            if (domainObject.containsAutoIncrementPK()) {
//                ResultSet rsID = statement.getGeneratedKeys();
//                if (rsID.next()) {
//                    //person.setPersonID(rsID.getLong(1));
//                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
//                }
//                rsID.close();
//            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void delete(DomainObject domainObject) throws SQLException {
        try {
            String query = "DELETE FROM " + domainObject.getTableName() + " WHERE clientID = ?";

            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //postavljanje vrednosti parametara
            domainObject.setParamsForDelete(statement, domainObject);

            //izvsi upit
            int result = statement.executeUpdate();
            //System.out.println("Result = " + result);
            System.out.println("Objekat uspesno izmenje u bazi!");

            //pristup generisanom kljucu
//            if (domainObject.containsAutoIncrementPK()) {
//                ResultSet rsID = statement.getGeneratedKeys();
//                if (rsID.next()) {
//                    //person.setPersonID(rsID.getLong(1));
//                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
//                }
//                rsID.close();
//            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

}
