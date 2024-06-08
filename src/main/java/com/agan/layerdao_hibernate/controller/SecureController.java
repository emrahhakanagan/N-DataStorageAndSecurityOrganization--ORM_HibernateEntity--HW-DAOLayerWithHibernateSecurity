package com.agan.layerdao_hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("/security")
public class SecureController {

    @GetMapping("/welcome")
    public String welcome() {
        return "<h1> This is a WELCOME endpoint </h1>";
    }

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String read(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a READ endpoint";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/write")
    public String write(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a WRITE endpoint";
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/modify")
    public String modify(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a MODIFY endpoint";
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/user")
    public String user(@RequestParam String username, Principal principal) {
        return "Hello, " + principal.getName();
    }
}
