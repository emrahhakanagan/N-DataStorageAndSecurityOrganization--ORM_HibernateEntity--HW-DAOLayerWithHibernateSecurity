package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.PersonSecurityMethodRepository;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonSecurityMethodService {

    private final PersonSecurityMethodRepository personRepositoryJPAQueryJPQLSecurityMethod;

    public List<Person> getPersonsByCity(String city) {
        return personRepositoryJPAQueryJPQLSecurityMethod.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepositoryJPAQueryJPQLSecurityMethod.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepositoryJPAQueryJPQLSecurityMethod.findByNameAndSurname(name, surname);
    }
}
