package com.agan.layerdao_hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class SecureController {

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String read() {
        return "This is a READ endpoint";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/write")
    public String write() {
        return "This is a WRITE endpoint";
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/modify")
    public String modify() {
        return "This is a MODIFY endpoint";
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/user")
    public String user(@RequestParam String username, Principal principal) {
        return "Hello, " + principal.getName();
    }
}
