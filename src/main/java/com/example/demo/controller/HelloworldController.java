package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloworldController {
    @GetMapping(value = "/api/helloWorld")
    public String helloWorrld() {
        return "HelloWorld";
    }
}
