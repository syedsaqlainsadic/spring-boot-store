package com.firstspringproject.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name", "Saqlain");

        return "index";
    }
    
}
