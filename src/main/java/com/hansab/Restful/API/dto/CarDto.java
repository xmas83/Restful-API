package com.hansab.Restful.API.dto;

public class CarDto {

    private int id;

    private String make;

    private String model;

    private String numberplate;

    public CarDto() {

    }

    public CarDto(String make, String model, String numberplate) {
        this.make = make;
        this.model = model;
        this.numberplate = numberplate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

}
