/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Employee;

/**
 *
 * @author student2
 */
public class LoginUser extends AbstractSO {

    private Employee employee;

    public LoginUser() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        employee = databaseBroker.getUser((Employee) object);
        if (employee == null) {
            throw new Exception("Korisnik ne postoji.");
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Employee)) {
            throw new Exception("Object is not valid");
        }
    }

}
