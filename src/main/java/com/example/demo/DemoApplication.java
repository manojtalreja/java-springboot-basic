package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@RestController
@SpringBootApplication
@EnableConfigurationProperties
@Configuration
public class DemoApplication {
   
    @Autowired
    DbCollectorJobsConfig dbCollectorJobsConfig;
    
    @Value("${spring.test.env:'Manoj'}")
    private String name;
   
    @RequestMapping("/")
    String home() {
        String message;

        message = this.name + " - " + dbCollectorJobsConfig.getJobs().size();
        for (DbCollectorJobsConfig.Job job: dbCollectorJobsConfig.getJobs()) {
            message += job.getEnabled();    
        }
        return ("Hello World -> " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
