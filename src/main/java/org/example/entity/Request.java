package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Request {
    @Id
    private int id;
    private String name;
    private long phoneNumber;
    private String question;

    public Request(){}

    public Request(String name, long phoneNumber, String question) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
