package com.example.demo.repository;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
    @Transactional
    @Modifying
    @Query("UPDATE Person person SET person.nume = :nume, person.age = :age WHERE person.id =:id  ")
    void updateById(@Param("id") Integer id, @Param("nume") String nume, @Param("age") Integer age);

}
