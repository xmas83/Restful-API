package com.hansab.Restful.API.controller;


import com.hansab.Restful.API.dto.CarDto;
import com.hansab.Restful.API.dto.UserDto;
import com.hansab.Restful.API.exception.ResourceNotFoundException;
import com.hansab.Restful.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081/")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            return userService.getAllUsers();
        }
        throw new ResourceNotFoundException("Currently, there are no users registered in the database!");
    }


    @GetMapping("/users/{userId}/cars")
    public List<CarDto> getUserCars(@PathVariable("userId") int userId) {
        List<CarDto> usersCars = userService.getUserCars(userId);
        if (usersCars != null) {
            return userService.getUserCars(userId);
        }
        throw new ResourceNotFoundException("There is no user with ID " + userId + " that has registered a car!");
    }


    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable("userId") int userId) {
        UserDto user = userService.getUserById(userId);
        if (user != null) {
            return userService.getUserById(userId);
        }
        throw new ResourceNotFoundException("The user with the id: (" + userId + ") not found!");
    }
}