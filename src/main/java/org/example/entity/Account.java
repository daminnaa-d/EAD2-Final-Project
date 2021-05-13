package org.example.entity;

import org.example.exception.PasswordException;

import java.io.Serializable;
import java.util.ArrayList;


public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private ArrayList<Request> requests = new ArrayList<>();
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public Account(String firstname, String lastname, String email, String password) throws PasswordException {
       if(password.length() < 8){
           throw new PasswordException("Data are not valid!");
       }
       else {
           this.firstname = firstname;
           this.lastname = lastname;
           this.email = email;
           this.password = password;
       }
    }

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
