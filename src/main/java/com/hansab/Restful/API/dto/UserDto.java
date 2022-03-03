package com.hansab.Restful.API.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private int id;

    private String name;

    private List<CarDto> cars = new ArrayList<>();

    public UserDto() {

    }

    public UserDto(String name, List<CarDto> cars) {
        this.name = name;
        this.cars = cars;
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

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

}
