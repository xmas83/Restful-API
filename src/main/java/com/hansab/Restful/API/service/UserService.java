package com.hansab.Restful.API.service;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> getAllUsers();

    List<CarDto> getUserCars(int userId);

    UserDto getUserById(int userId);
}
