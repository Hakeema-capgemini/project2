package com.example.project2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.service.UserService;
import com.example.project2.vo.UserVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RestController
@RequestMapping("/app2/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 @Autowired
	private final UserService userService;

   
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/feign/{id}")
     public ResponseEntity<UserVO> getUserUsingFeign(@PathVariable("id") Long userId) {
       logger.info("Received request to get user via Feign Client, ID: {}", userId);
       UserVO userVO = userService.getUserUsingFeign(userId);
       logger.info("Retrieved user via Feign Client: {}", userVO);
            return ResponseEntity.ok(userVO);
    }
    @GetMapping("/rest/{id}")
    public ResponseEntity<UserVO> getUserUsingRestTemplate(@PathVariable("id") Long id) {
        logger.info("Received request to get user via RestTemplate, ID: {}", id);
        UserVO userVO = userService.getUserUsingRestTemplate(id);
        logger.info("Retrieved user via RestTemplate: {}", userVO);
        return ResponseEntity.ok(userVO);
    }
  }
