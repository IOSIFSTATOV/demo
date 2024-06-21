package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    @Modifying
    @Query("UPDATE Car car SET car.number = :number, car.model = :model WHERE car.serial_number = :serial_number  ")
    void updateById(@Param("serial_number") Integer serialNumber, @Param("number") String number, @Param("model") String model);

}
