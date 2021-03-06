package com.hansab.Restful.API.service;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDto> getAllCars();

    CarDto getCarById(int carId) throws ResourceNotFoundException;
}
