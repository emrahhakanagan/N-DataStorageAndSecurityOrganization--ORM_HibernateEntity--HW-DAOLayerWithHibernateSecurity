package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.PersonRepositoryJPA;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceJPA {

    private final PersonRepositoryJPA personRepositoryJpa;

    public List<Person> getPersonsByCity(String city) {
        return personRepositoryJpa.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepositoryJpa.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepositoryJpa.findByNameAndSurname(name, surname);
    }
}
