package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serial_number;

    @Column(name = "number")
    private String number;

    @Column(name = "model")
    private String model;

    public Car(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Car() {
    }

    public Integer getSerial_number() {
        return serial_number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
