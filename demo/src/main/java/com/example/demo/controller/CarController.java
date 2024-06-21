package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CarDto carDto) {
        this.carService.create(carDto);
        return ResponseEntity.ok("Пользователь создан");
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
