package com.example.project2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.project2.vo.UserVO;

@FeignClient(name = "userClient", url = "http://localhost:8080") //App1 url

public interface UserFeignClient {

	@GetMapping("/app1/api/users/retrieve/{id}")
    UserVO getUserById(@PathVariable("id") Long id);
}
