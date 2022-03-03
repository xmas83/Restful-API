package com.hansab.Restful.API.service.serviceimpl;


import com.hansab.Restful.API.Entity.Car;
import com.hansab.Restful.API.Repository.CarRepository;
import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private ModelMapper modelMapper;

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<CarDto> carDtos = null;
        List<Car> cars = carRepository.findAll();
        if (cars != null) {
            carDtos = cars.stream().map(car -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
        }
        return carDtos;
    }


    @Override
    public CarDto getCarById(int carId) throws RuntimeException{
        CarDto carDto = null;
        Car car = carRepository.findById(carId).orElse(null);
        if (car != null) {
            carDto = modelMapper.map(car, CarDto.class);
        }
        return carDto;
    }
}
