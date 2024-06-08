package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import java.util.List;

@Configuration
public class DbCollectorJobsConfig {
  private List<Job> jobs;

  public static class Job {
    private String name;
    private boolean enabled=false;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public boolean getEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }
  }

  
  @Bean("dbCollectorJobs")
  @ConfigurationProperties("db-collector-jobs")
  public List<Job> dbCollectorJobs() {
    return new ArrayList<>();
  }

}
