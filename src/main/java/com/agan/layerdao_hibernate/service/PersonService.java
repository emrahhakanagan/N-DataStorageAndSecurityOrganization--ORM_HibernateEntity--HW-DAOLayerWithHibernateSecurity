package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class PersonService {

    private final PersonRepository personRepository;


    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
