package com.example.project2.service;

import org.springframework.stereotype.Service;

import com.example.project2.vo.UserVO;
@Service
public interface UserService {
	
	void saveUser(UserVO userVO); // Save user data
    UserVO getUserUsingRestTemplate(Long id); // Retrieve user from App1 using RestTemplate
    UserVO getUserUsingFeign(Long id); 
}
