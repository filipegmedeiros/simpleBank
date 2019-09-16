package com.simpleBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloWorldController {
    @GetMapping
    public String helloGradle() {
        return "Hello Gradle!";
    }

}