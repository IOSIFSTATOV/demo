package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  POST  ->   http://localhost:8080/people
//  GET   ->   http://localhost:8080/people
//  GET   ->   http://localhost:8080/people/32

@RestController
@RequestMapping("/people")
@Validated
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PersonDto personDto) {
        this.personService.create(personDto);
    }

    @GetMapping
    public List<PersonDto> getAll() {
        return this.personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable @Min(value = 13, message = "id must be bigger") Integer id) {
        return this.personService.getById(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable Integer id,
                           @RequestBody PersonDto personDto) {
        this.personService.updateById(id, personDto.getNume(), personDto.getAge());
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        this.personService.deleteById(id);
    }
}
