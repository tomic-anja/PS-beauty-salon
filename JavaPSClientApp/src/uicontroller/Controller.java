/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Client;
import domain.Employee;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Cartman
 */
public class Controller {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        Request request = new Request(Operation.LOGIN, employee);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Employee) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Client> getAllClients() throws Exception {
        Request request = new Request(Operation.GET_ALL_CLIENTS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Client>) response.getResult();
        } else {
            throw response.getException();
        }
    }

//    public void createPerson(Person person) throws Exception {
//        Request request=new Request(Operation.ADD_PERSON, person);
//        sender.send(request);
//        Response response=(Response)receiver.receive();
//        if(response.getException()==null){
//            person.setPersonID(((Person)response.getResult()).getPersonID());
//        }else{
//            throw response.getException();
//        }
//    }
//
//    public List<City> getAllCities() throws Exception {
//        Request request=new Request(Operation.GET_ALL_CITIES, null);
//        sender.send(request);
//        Response response=(Response)receiver.receive();
//        if(response.getException()==null){
//            return (List<City>)response.getResult();
//        }else{
//            throw response.getException();
//        }
//    }
    public void createClient(Client client) throws Exception {
        Request request = new Request(Operation.ADD_CLIENT, client);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            client.setClientID(((Client) response.getResult()).getClientID());
        } else {
            throw response.getException();
        }
    }

    public void updateClient(Client selectedClient) throws Exception {
        Request request = new Request(Operation.UPDATE_CLIENT, selectedClient);
        sender.send(request);
        Response response = (Response) receiver.receive();

    }

    public void deleteClient(Client selectedClient) throws Exception {
        Request request = new Request(Operation.DELETE_CLIENT, selectedClient);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }
}
