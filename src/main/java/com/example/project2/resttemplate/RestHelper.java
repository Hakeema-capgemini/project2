package com.example.project2.resttemplate;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Configuration
@Component
public class RestHelper {

  
    private final  RestTemplate restTemplate;
  
    	public RestHelper() {
            this.restTemplate = new RestTemplate();
    	}
    	 public <T> T getForObject(String url, Class<T> clazz) {
    	 return restTemplate.getForObject(url, clazz);

    }
}
