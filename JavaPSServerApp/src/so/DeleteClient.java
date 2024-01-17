/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Client;

/**
 *
 * @author Dell E5450
 */
public class DeleteClient extends AbstractSO {

    public DeleteClient() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.delete((Client) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Client)) {
            throw new Exception("Object is not valid");
        }
        //dodatno izvrsi validaciju na vrednosti
        Client client = (Client) object;
        if (client.getName().isEmpty()) {
            throw new Exception("Name is empty");
        }
    }

}
