package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
@Configuration
public class DemoApplication {
    private final DbCollectorJobsConfig dbCollectorJobsConfig;

    public DemoApplication(DbCollectorJobsConfig dbCollectorJobsConfig) {
        this.dbCollectorJobsConfig = dbCollectorJobsConfig;
    }
    
    @Value("${spring.test.env:'Manoj'}")
    private String name;
   
    @RequestMapping("/")
    String home() {
        String message = this.name;

        message += dbCollectorJobsConfig.getJobs().length();
        for (DbCollectorJobsConfig.Job job: dbCollectorJobsConfig.getJobs()) {
            message += job.getEnabled();    
        }
        return ("Hello World !!! " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
