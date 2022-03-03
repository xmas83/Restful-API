package com.hansab.Restful.API.service;


import com.hansab.Restful.API.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    public List<CarDto> getAllCars();

    public CarDto getCarById(int carId) throws RuntimeException;
}
