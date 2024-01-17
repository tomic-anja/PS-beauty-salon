/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Client;
import domain.Employee;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class GetAllClients extends AbstractSO {

    private List<Client> clients;

    public GetAllClients() throws Exception {
        super();
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        clients = databaseBroker.getClients();
        if (clients == null) {
            throw new Exception("Klijenti ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Client)) {
            throw new Exception("Object is not valid");
        }
    }

}
