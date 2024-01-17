/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Client;
import domain.Employee;
//import domain.Person;
import java.net.Socket;
import logic.Controller;
import server.Server;

/**
 *
 * @author student2
 */
public class ClientThread extends Thread {

    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private Employee employee;
    private Server server;

    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
        this.server = server;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Employee employee = (Employee) request.getArgument();
                            //Proveri da li employee vec ne postoji u listi
                            if (server.notLogin(employee)) {
                                response.setResult(controller.login(employee));
                                this.employee = employee;
                            } else {
                                throw new Exception("User je vec prijavljen.");
                                //to do
                            }
                            break;

                        case GET_ALL_CLIENTS:
//                            response.setResult(controller.getAllCities());
                            response.setResult(controller.getAllClients());
                            break;
                        case ADD_CLIENT:
                            Client client = (Client) request.getArgument();
                            controller.createClient(client);
                            response.setResult(client);
//                            Person person = (Person) request.getArgument();
//                            controller.createPerson(person);
//                            response.setResult(person);
                            break;
                        case UPDATE_CLIENT:
                            Client updatedClient = (Client) request.getArgument();
                            controller.updateClient(updatedClient);
                            response.setResult(updatedClient);
                            break;
                        case DELETE_CLIENT:
                            Client selectedClient = (Client) request.getArgument();
                            controller.deleteClient(selectedClient);
                            response.setResult(selectedClient);
                            break;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public Employee getLoginUser() {
        return employee;
    }
}
