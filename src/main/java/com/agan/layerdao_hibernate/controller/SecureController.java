package com.agan.layerdao_hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/security-test")
public class SecureController {

    @GetMapping("/welcome")
    public String welcome() {
        return "<h1> This is a WELCOME endpoint </h1>";
    }


    @GetMapping("/read")
    public String read(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a READ endpoint";
    }


    @GetMapping("/write")
    public String write(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a WRITE endpoint";
    }


    @GetMapping("/modify")
    public String modify(Principal principal) {
        return "<h2> Hi " + principal.getName() + "</h2> This is a MODIFY endpoint";
    }


    @GetMapping("/user")
    public String user(@RequestParam String username, Principal principal) {
        return "Hello, " + principal.getName() + " username is " + username;
    }
}
