package com.example.project2.bo;


import org.springframework.stereotype.Service;

import com.example.project2.dto.UserDTO;
@Service
public interface UserBO {
	
	UserDTO saveUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
}