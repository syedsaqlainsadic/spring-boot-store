package com.firstspringproject.store.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.firstspringproject.store.entities.message;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class MessageController {

    @RequestMapping("/hello")
    public message sayHello() {
        return new message("Hello, World!");
    }
}
