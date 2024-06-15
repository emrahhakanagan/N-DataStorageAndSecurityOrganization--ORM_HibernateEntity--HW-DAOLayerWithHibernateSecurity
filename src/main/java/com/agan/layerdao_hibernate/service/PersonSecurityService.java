package com.agan.layerdao_hibernate.service;

import com.agan.layerdao_hibernate.dao.MyUserDAO;
import com.agan.layerdao_hibernate.dao.PersonSecurityRepository;
import com.agan.layerdao_hibernate.entity.MyUser;
import com.agan.layerdao_hibernate.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonSecurityService {

    private final PersonSecurityRepository personSecurityRepository;
    private final MyUserDAO myUserDAO;
    private PasswordEncoder encoder;


    public List<Person> getPersonsByCity(String city) {
        return personSecurityRepository.findByCityOfLiving(city);
    }


    public List<Person> getPersonsByAgeLessThan(int age) {
        return personSecurityRepository.findByAgeLessThanOrderByAgeAsc(age);
    }


    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personSecurityRepository.findByNameAndSurname(name, surname);
    }

    public void addUser(MyUser user) {
        user.setPassword(encoder.encode(user.getPassword()));

        if(user.getRoles().contains(",")) {
            String roleWithPrefix = Arrays.stream(user.getRoles().split(","))
                    .map((role) -> "ROLE_" + role.trim())
                    .collect(Collectors.joining(","));
            user.setRoles(roleWithPrefix);
        } else {
            user.setRoles("ROLE_" + user.getRoles().trim());
        }

        myUserDAO.save(user);
    }
}
