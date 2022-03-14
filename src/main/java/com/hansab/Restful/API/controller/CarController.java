package com.hansab.Restful.API.controller;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.exception.ResourceNotFoundException;
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

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        if (!cars.isEmpty()) {
            return carService.getAllCars();
        }
        throw new ResourceNotFoundException("Currently, there are no cars registered in the database!");
    }


    @GetMapping("/cars/{carId}")
    public CarDto getCar(@PathVariable("carId") int carId) {
        CarDto car = carService.getCarById(carId);
        if (car != null) {
            return carService.getCarById(carId);
        }
        throw new ResourceNotFoundException("The car with the id: (" + carId + ") not found!");
    }
}