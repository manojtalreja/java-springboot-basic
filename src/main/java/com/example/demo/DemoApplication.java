package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
@SpringBootApplication
@Configuration
public class DemoApplication {
   
    
    private List<DbCollectorJobsConfig.Job> dbCollectorJobsConfig;
    
    @Value("${spring.test.env:'Manoj'}")
    private String name;

    @Autowired
    public DemoApplication(@Qualifier("dbCollectorJobs") List<DbCollectorJobsConfig.Job> jobsConfig) {
       this.dbCollectorJobsConfig = jobsConfig;
    }
   
    @RequestMapping("/")
    String home() {
       String message = this.name;

       for (DbCollectorJobsConfig.Job job: dbCollectorJobsConfig) {
            message += job.getEnabled();    
        }
       
       return ("Hello World -> " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
