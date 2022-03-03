package com.hansab.Restful.API.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    @ElementCollection
    private List<Car> cars = new ArrayList<>();


    public User() {

    }

    public User(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

}
