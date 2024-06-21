package com.example.demo.model;


import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

/**
 * @author Neil Alishev
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "age")
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serial_number")
    private Car car;

    public Person() {
    }

    public Person(String nume, int age) {
        this.nume = nume;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
