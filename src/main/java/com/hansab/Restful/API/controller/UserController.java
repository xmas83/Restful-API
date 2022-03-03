package com.hansab.Restful.API.controller;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import com.hansab.Restful.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081/")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}/cars")
    public List<CarDto> getUserCars(@PathVariable("userId") int userId) {
        return userService.getUserCars(userId);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

}
