package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void create(@RequestBody CarDto carDto) {
        this.carService.create(carDto);
    }

    @GetMapping
    public List<CarDto> getAll() {
        return this.carService.getAll();
    }

    @PutMapping("{serial_number}")
    public void updateById(@PathVariable Integer serialNumber,
                           @RequestBody CarDto carDto) {
        this.carService.updateById(serialNumber, carDto.getNumber(), carDto.getModel());
    }

}
