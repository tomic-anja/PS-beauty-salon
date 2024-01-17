/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Client;
import domain.Employee;
import java.util.List;
import so.DeleteClient;
import so.GetAllClients;
import so.LoginUser;
import so.SaveClient;
import so.UpdateClient;

/**
 *
 * @author Cartman
 */
public class Controller {

    public Employee login(Employee employee) throws Exception {
        LoginUser loginUser = new LoginUser();
        // User u= loginUser.execute(user);
        loginUser.execute(employee);
        return loginUser.getEmployee();
    }
//
//    public void createPerson(Person person) throws Exception {
//        SavePerson savePerson = new SavePerson();
//        savePerson.execute(person);
//    }
//
//    public List<City> getAllCities() throws Exception {
//        GetAllCities getAllCities = new GetAllCities();
//        getAllCities.execute(new City());
//        return getAllCities.getCities();
//    }

    public Object getAllClients() throws Exception {
        GetAllClients getAllClients = new GetAllClients();
        getAllClients.execute(new Client());
        return getAllClients.getClients();
    }

    public void createClient(Client client) throws Exception {
        SaveClient saveClient = new SaveClient();
        saveClient.execute(client);
    }

    public void updateClient(Client updatedClient) throws Exception {
        UpdateClient updateClient = new UpdateClient();
        updateClient.execute(updatedClient);
    }

    public void deleteClient(Client selectedClient) throws Exception {
        DeleteClient deleteClient = new DeleteClient();
        deleteClient.execute(selectedClient);
    }

}
