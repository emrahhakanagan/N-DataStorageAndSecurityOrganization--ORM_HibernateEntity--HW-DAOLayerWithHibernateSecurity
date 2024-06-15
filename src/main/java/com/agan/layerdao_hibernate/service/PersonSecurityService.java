package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.PersonSecurityRepository;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonSecurityService {

    private final PersonSecurityRepository personSecurityRepository;

    public List<Person> getPersonsByCity(String city) {
        return personSecurityRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personSecurityRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personSecurityRepository.findByNameAndSurname(name, surname);
    }
}
