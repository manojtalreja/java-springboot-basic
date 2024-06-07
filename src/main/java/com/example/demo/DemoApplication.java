package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@RestController
@SpringBootApplication
@Configuration
public class DemoApplication {
    
    @Value("${spring.test.env:'Manoj'}")
    private String name;
   
    @RequestMapping("/")
    String home() {
        return ("Hello World! " + this.name);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
