package com.hansab.Restful.API.Repository;

import com.hansab.Restful.API.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
