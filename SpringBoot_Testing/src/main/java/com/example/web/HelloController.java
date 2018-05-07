package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dell on 5/6/2018.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String printHelloWorld(){
        return "Hello World!";
    }
}
