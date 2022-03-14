package com.hansab.Restful.API.service;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import com.hansab.Restful.API.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> getAllUsers();

    List<CarDto> getUserCars(int userId) throws ResourceNotFoundException;

    UserDto getUserById(int userId) throws ResourceNotFoundException;
}
