package com.hansab.Restful.API;

import com.hansab.Restful.API.Entity.Car;
import com.hansab.Restful.API.Entity.User;
import com.hansab.Restful.API.Repository.CarRepository;
import com.hansab.Restful.API.Repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestfulApiApplicationTests {

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(1)
    void createACar() {
        Car car = new Car();
        car.setId(4);
        car.setMake("Peugeot");
        car.setModel("M4");
        car.setNumberplate("BBB340");
        carRepository.save(car);
        assertNotNull(carRepository.findById(4).get());
    }

    @Test
    @Order(2)
    public void readAllCars() {
        List<Car> carList = carRepository.findAll();
        assertThat(carList).size().isGreaterThan(0);
    }

    @Test
	@Order(3)
    public void getUserByFirstName() {
        User user = userRepository.findById(1).get();
        assertEquals("John", user.getName());
    }

    @Test
	@Order(4)
    public void updateUserFirstName() {
        User user = userRepository.findById(1).get();
        user.setName("Philip");
        userRepository.save(user);
        assertNotEquals("John", userRepository.findById(1).get().getName());
    }

    @Test
	@Order(5)
    public void deleteUser() {
        userRepository.deleteById(1);
        assertThat(userRepository.existsById(1)).isFalse();
    }
}
