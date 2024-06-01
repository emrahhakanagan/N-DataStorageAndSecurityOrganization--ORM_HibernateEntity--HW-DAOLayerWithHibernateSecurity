package com.agan.layerdao_hibernate.controller;

import com.agan.layerdao_hibernate.entity.Order;
import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.service.PersonServiceJPA_QueryJPQL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons-jpa-query-jpql-security")
public class PersonControllerJPA_QueryJPQL_Security {

    private final PersonServiceJPA_QueryJPQL personServiceJpaQueryJpql;

    @GetMapping("/by-city")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        List<Person> persons = personServiceJpaQueryJpql.getPersonsByCity(city);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-age")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByAgeLessThan(@RequestParam int age) {
        List<Person> persons = personServiceJpaQueryJpql.getPersonsByAgeLessThan(age);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-name-surname")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personServiceJpaQueryJpql.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
