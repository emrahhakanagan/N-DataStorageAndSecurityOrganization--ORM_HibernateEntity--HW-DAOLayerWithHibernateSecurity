package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.dao.PersonDAOImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class PersonService {

    private final PersonDAOImpl personDAOImpl;


    public List<Person> getPersonsByCity(String city) {
        return personDAOImpl.getPersonsByCity(city);
    }
}
