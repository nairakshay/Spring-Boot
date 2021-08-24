package com.akshay.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller
@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    //@RequestMapping(value="/",method= RequestMethod.GET)//Calls the method whenever we hit localhost:8080/
    @GetMapping("/")
    public String hellWorld(){

        //return "Hello Spring Boot";
        return welcomeMessage;
    }
}
