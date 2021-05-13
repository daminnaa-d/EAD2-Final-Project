package org.example.entity;

public class Schedule {

    private String programme;
    private String time;
    private double price;
    private String trainer;

    public Schedule(){}

    public Schedule(String programme, String time, double price, String trainer) {
        this.programme = programme;
        this.time = time;
        this.price = price;
        this.trainer = trainer;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
}
