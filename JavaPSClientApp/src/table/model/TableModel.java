/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dell E5450
 */
public class TableModel extends AbstractTableModel {

    private List<Client> clients = new ArrayList<>();
    private String[] columns = {"Name", "Surname", "Phone number"};

    public TableModel(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getSurname();
            case 2:
                return client.getPhoneNumber();

            default:
                return "n/a";
        }
    }

}
