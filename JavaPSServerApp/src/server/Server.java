/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Employee;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import logic.Controller;
import thread.ClientThread;

/**
 *
 * @author Cartman
 */
public class Server {

    private Controller controller;
    private List<ClientThread> clients;

    public Server() {
        this.controller = new Controller();
        clients = new ArrayList<>();
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clients.add(clientThread);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean notLogin(Employee employee) {
        for (ClientThread client : clients) {
            if (employee.equals(client.getLoginUser())) {
                return false;
            }
        }
        return true;
    }
}
