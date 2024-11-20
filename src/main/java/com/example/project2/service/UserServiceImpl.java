package com.example.project2.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project2.bo.UserBO;
import com.example.project2.client.UserFeignClient;
import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.UserMapper;
import com.example.project2.resttemplate.RestHelper;
import com.example.project2.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserMapper userMapper;
    private final UserBO userBO;
    private final RestHelper restHelper;
    private final UserFeignClient userFeignClient;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserBO userBO, RestHelper restHelper, UserFeignClient userFeignClient) {
        this.userMapper = userMapper;
        this.userBO = userBO;
        this.restHelper = restHelper;
        this.userFeignClient = userFeignClient;
    }

    @Override
    public void saveUser(UserVO userVO) {
        logger.info("Mapping UserVO to UserDTO: {}", userVO);
        UserDTO userDTO = userMapper.toDTO(userVO); // Map VO to DTO
        userBO.saveUser(userDTO); // Delegate to BO
    }

    @Override
    public UserVO getUserUsingRestTemplate(Long id) {
        String url = "http://localhost:8082/api/users/retrieve/" + id;
        logger.info("Calling App1 endpoint using RestTemplate: {}", url);
        UserVO userVO = restHelper.getForObject(url, UserVO.class);
        logger.info("Received response from App1 using RestTemplate: {}", userVO);
        return userVO;
    }

    @Override
    public UserVO getUserUsingFeign(Long id) {
        logger.info("Calling App1 endpoint using Feign client, ID: {}", id);
        UserVO userVO = userFeignClient.getUserById(id);
        logger.info("Received response from App1 using Feign client: {}", userVO);
        return userVO;
    }
}