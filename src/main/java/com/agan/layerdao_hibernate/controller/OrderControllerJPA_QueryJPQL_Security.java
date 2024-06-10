package com.agan.layerdao_hibernate.controller;

import com.agan.layerdao_hibernate.entity.Order;
import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.service.PersonServiceJPA_QueryJPQL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/orders-jpa-query-jpql-security")
public class OrderControllerJPA_QueryJPQL_Security {

    private final PersonServiceJPA_QueryJPQL personServiceJpaQueryJpql;
//
//    @GetMapping("/all-orders/{username}")
//    public ResponseEntity<List<Order>> getAllOrdersByUsername() {
//
//    }
//
//
//    @GetMapping

}
