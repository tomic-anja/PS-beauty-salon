/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class Hall implements Serializable {

    private int hallID;
    private String adress;
    private int floor;

//    private List<Appointment> appointments = new ArrayList<>();
    public Hall() {
    }

    public Hall(int hallID, String adress, int floor) {
        this.hallID = hallID;
        this.adress = adress;
        this.floor = floor;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//}
    @Override
    public String toString() {
        return "Hall{" + "hallID=" + hallID + ", adress=" + adress + ", floor=" + floor + '}';
    }

}
