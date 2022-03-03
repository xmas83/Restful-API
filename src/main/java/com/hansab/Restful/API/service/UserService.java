package com.hansab.Restful.API.service;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<UserDto> getAllUsers();

    public List<CarDto> getUserCars(int userId) throws RuntimeException;

    public UserDto getUserById(int userId) throws RuntimeException;
}
