package com.agan.layerdao_hibernate.controller;

import com.agan.layerdao_hibernate.entity.MyUser;
import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.service.PersonSecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/security")
public class PersonSecurityController {

    private final PersonSecurityService personSecurityService;
//    private PasswordEncoder encoder;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        return ResponseEntity
                .ok("<h1>" + name + "</h1> Welcome to page without authenticate");
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        personSecurityService.addUser(user);

        return "User saved ...";
    }

    @GetMapping("/by-city")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        List<Person> persons = personSecurityService.getPersonsByCity(city);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);

    }

    @GetMapping("/by-age")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> getPersonsByAgeLessThan(@RequestParam int age) {
        List<Person> persons = personSecurityService.getPersonsByAgeLessThan(age);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-name-surname")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personSecurityService.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
