package com.hansab.Restful.API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private int id;

    private String make;

    private String model;

    private String numberplate;

}
