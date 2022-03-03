package com.hansab.Restful.API.controller;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:8081/")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/{carId}")
    public CarDto getCar(@PathVariable("carId") int carId) {
        return carService.getCarById(carId);
    }
}
