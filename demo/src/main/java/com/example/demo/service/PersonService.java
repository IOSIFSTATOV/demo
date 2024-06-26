package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void create(PersonDto personDto) {
        Person person = new Person(personDto.getNume(), personDto.getAge());
        personRepository.save(person);
    }

    public List<PersonDto> getAll() {
        Iterable<Person> people = personRepository.findAll();
        return StreamSupport.stream(people.spliterator(), false)
                .map(person -> new PersonDto(person.getNume(), person.getAge()))
                .toList();
    }

    public PersonDto getById(Integer id) {
        Optional<Person> people = personRepository.findById(id);
        if (people.isEmpty()) {
            throw new DataNotFoundException("Person not found by id: " + id);
        }
        Person person = people.get();
        return new PersonDto(person.getNume(), person.getAge());
    }

    public void updateById(Integer id, String nume, Integer age) {
        personRepository.updateById(id, nume, age);
    }

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }
}
