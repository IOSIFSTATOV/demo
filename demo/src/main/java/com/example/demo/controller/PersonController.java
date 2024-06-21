package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//  POST  ->   http://localhost:8080/people
//  GET   ->   http://localhost:8080/people
//  GET   ->   http://localhost:8080/people/32

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public void create(@RequestBody PersonDto personDto) {
        this.personService.create(personDto);
    }

    @GetMapping
    public List<PersonDto> getAll() {
        return this.personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Integer id) {
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
