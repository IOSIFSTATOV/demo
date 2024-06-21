package com.example.demo.dto;

public class CarDto {

    private Integer serialNumber;

    private String number;

    private String model;

    public CarDto(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public CarDto() {
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
