package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Value("${spring.test.env}")
    private static final String NAME;
    
    @RequestMapping("/")
    String home() {
        return ("Hello World! " + NAME);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
