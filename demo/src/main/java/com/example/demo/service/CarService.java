package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void create(CarDto carDto) {
        Car car = new Car(carDto.getNumber(), carDto.getModel());
        carRepository.save(car);
    }

    public List<CarDto> getAll() {
        Iterable<Car> cars = carRepository.findAll();
        return StreamSupport.stream(cars.spliterator(), false)
                .map(car -> new CarDto(car.getNumber(), car.getModel()))
                .toList();
    }

    public CarDto findBySerialNumber(Integer serialNumber) {
        Optional<Car> cars = carRepository.findById(serialNumber);
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Car car = cars.get();
        return new CarDto(car.getNumber(), car.getModel());
    }

    public void updateById(Integer serialNumber, String numberOfCar, String carModel) {
//        carRepository.updateById(serialNumber, numberOfCar, carModel);
    }
}
