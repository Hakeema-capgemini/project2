package com.example.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.example.project")
@EnableFeignClients
@ComponentScan(basePackages = "com.example.project2")
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}
	 @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
  }
}