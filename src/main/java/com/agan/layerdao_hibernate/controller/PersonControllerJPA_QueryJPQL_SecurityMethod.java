package com.agan.layerdao_hibernate.controller;

import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.service.PersonServiceJPA_QueryJPQL_SecurityMethod;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/security-method")
public class PersonControllerJPA_QueryJPQL_SecurityMethod {

    private final PersonServiceJPA_QueryJPQL_SecurityMethod personServiceJPAQueryJPQLSecurityMethod;


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("<h1> Welcome to -Security Method- page, which is without authorization </h1>");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        List<Person> persons = personServiceJPAQueryJPQLSecurityMethod.getPersonsByCity(city);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(persons);
    }

    @RolesAllowed("ROLE_USER")
    @GetMapping("/by-age")
    public ResponseEntity<List<Person>> getPersonsByAgeLessThan(@RequestParam int age) {
        List<Person> persons = personServiceJPAQueryJPQLSecurityMethod.getPersonsByAgeLessThan(age);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/by-name-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String username,
            @RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personServiceJPAQueryJPQLSecurityMethod.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
