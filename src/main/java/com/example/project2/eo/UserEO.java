package com.example.project2.eo;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.project2.dto.UserDTO;
@Service
@Component
public interface UserEO {
	UserDTO save(UserDTO userDTO);
    UserDTO findById(Long id);
    
}	    


       
