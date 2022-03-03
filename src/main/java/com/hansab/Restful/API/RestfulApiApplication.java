package com.hansab.Restful.API;

import com.hansab.Restful.API.Entity.Car;
import com.hansab.Restful.API.Entity.User;
import com.hansab.Restful.API.Repository.CarRepository;
import com.hansab.Restful.API.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestfulApiApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    @Bean
    public CommandLineRunner run() {
        return args -> {

            Car car1 = new Car("Audi", "G7", "TTT345");
            Car car2 = new Car("BMW", "B5", "WWW123");
            Car car3 = new Car("Mercedes", "A5", "BNK677");

            carRepository.save(car1);
            carRepository.save(car2);
            carRepository.save(car3);

            List<Car> carList1 = new ArrayList<>();
            carList1.add(car1);
            carList1.add(car2);

            List<Car> carList2 = new ArrayList<>();
            carList2.add(car3);


            User user1 = new User("John", carList1);
            User user2 = new User("Harry", carList2);

            userRepository.save(user1);
            userRepository.save(user2);

        };
    }
}
