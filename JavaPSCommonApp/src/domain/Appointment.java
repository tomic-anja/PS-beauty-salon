/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Dell E5450
 */
public class Appointment implements Serializable {

    private int appointmentID;
    private LocalDate dateTime;
    private int duration;
    private Hall hall;

    public Appointment() {
    }

    public Appointment(int appointmentID, LocalDate dateTime, int duration, Hall hall) {
        this.appointmentID = appointmentID;
        this.dateTime = dateTime;
        this.duration = duration;
        this.hall = hall;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentID=" + appointmentID + ", dateTime=" + dateTime + ", duration=" + duration + ", hall=" + hall + '}';
    }

}
