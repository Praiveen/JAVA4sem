package com.example.prak11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RestHello {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, World, test only";
    }
}
