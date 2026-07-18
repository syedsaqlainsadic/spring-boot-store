package com.firstspringproject.store.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.firstspringproject.store.entities.message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public message sayHello() {
        return new message("Hello, World!");
    }
}
