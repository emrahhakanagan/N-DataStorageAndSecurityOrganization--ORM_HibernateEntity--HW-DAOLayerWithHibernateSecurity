package com.agan.layerdao_hibernate.controller;

import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
