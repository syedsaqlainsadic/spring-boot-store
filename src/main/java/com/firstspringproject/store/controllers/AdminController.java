package com.firstspringproject.store.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/Hello")
    public String sayHello() {
        return "Hello World";
    }

}
