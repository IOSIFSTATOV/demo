package com.example.demo.dto;

public class PersonDto {

    private String nume;
    private Integer age;

    public PersonDto() {
    }

    public PersonDto(String nume, Integer age) {
        this.nume = nume;
        this.age = age;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
