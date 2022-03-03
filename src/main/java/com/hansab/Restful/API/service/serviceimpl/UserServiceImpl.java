package com.hansab.Restful.API.service.serviceimpl;


import com.hansab.Restful.API.Entity.Car;
import com.hansab.Restful.API.Entity.User;
import com.hansab.Restful.API.Repository.UserRepository;
import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import com.hansab.Restful.API.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = null;
        List<User> users = userRepository.findAll();
        if (users != null) {
            userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        }
        return userDtos;
    }


    @Override
    public List<CarDto> getUserCars(int userId) throws RuntimeException {
        List<CarDto> carDtos = null;
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Car> cars = user.getCars();
            carDtos = cars.stream().map(car -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
        }
        return carDtos;
    }


    @Override
    public UserDto getUserById(int userId) throws RuntimeException {
        UserDto userDto = null;
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userDto = modelMapper.map(user, UserDto.class);
        }
        return userDto;
    }
}
