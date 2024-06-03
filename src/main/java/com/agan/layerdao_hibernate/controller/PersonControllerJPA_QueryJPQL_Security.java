package com.agan.layerdao_hibernate.controller;

import com.agan.layerdao_hibernate.entity.MyUser;
import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.service.PersonServiceJPA_QueryJPQL_Security;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons-jpa-query-jpql-security")
public class PersonControllerJPA_QueryJPQL_Security {

    private final PersonServiceJPA_QueryJPQL_Security personServiceJpaQuerySJpqlSecurity;
    private PasswordEncoder encoder;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        return ResponseEntity
                .ok(name + " Welcome to page without authenticate");
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        personServiceJpaQuerySJpqlSecurity.addUser(user);

        return "User saved ...";
    }

    @GetMapping("/by-city")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        List<Person> persons = personServiceJpaQuerySJpqlSecurity.getPersonsByCity(city);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-age")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByAgeLessThan(@RequestParam int age) {
        List<Person> persons = personServiceJpaQuerySJpqlSecurity.getPersonsByAgeLessThan(age);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-name-surname")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personServiceJpaQuerySJpqlSecurity.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
