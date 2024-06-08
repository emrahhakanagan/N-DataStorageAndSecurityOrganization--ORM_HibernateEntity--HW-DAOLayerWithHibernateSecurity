package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.PersonRepositoryJPA_QueryJPQL_SecurityMethod;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceJPA_QueryJPQL_SecurityService {

    private final PersonRepositoryJPA_QueryJPQL_SecurityMethod personRepositoryJPAQueryJPQLSecurityMethod;

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
