package com.hansab.Restful.API.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private String numberplate;


    public Car() {

    }

    public Car(String make, String model, String numberplate) {
        this.make = make;
        this.model = model;
        this.numberplate = numberplate;
    }

}
