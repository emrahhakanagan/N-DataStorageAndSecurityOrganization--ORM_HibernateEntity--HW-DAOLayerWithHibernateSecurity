package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.PersonRepositoryJPA_QueryJPQL;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceJPA_QueryJPQL {

    private final PersonRepositoryJPA_QueryJPQL personRepositoryJpaQueryJpql;

    public List<Person> getPersonsByCity(String city) {
        return personRepositoryJpaQueryJpql.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepositoryJpaQueryJpql.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepositoryJpaQueryJpql.findByNameAndSurname(name, surname);
    }
}
