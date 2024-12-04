package com.example.project2.UserServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.project2.bo.UserBO;
import com.example.project2.client.UserFeignClient;
import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.UserMapper;
import com.example.project2.resttemplate.RestHelper;
import com.example.project2.service.UserServiceImpl;
import com.example.project2.vo.UserVO;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
    private UserMapper userMapper;

    @Mock
    private UserBO userBO;

    @Mock
    private RestHelper restHelper;

    @Mock
    private UserFeignClient userFeignClient;

    @InjectMocks
    private UserServiceImpl userService;

    private UserVO mockUserVO;
    private UserDTO mockUserDTO;

    @BeforeEach
    void setUp() {
        mockUserVO = new UserVO();
        mockUserVO.setId(1L);
        mockUserVO.setName("Rizwana");

        mockUserDTO = new UserDTO();
        mockUserDTO.setId(1L);
        mockUserDTO.setName("Rizwana");
    }

    @Test
    void saveUser_ShouldInvokeBO() {
        when(userMapper.toDTO(mockUserVO)).thenReturn(mockUserDTO);

        userService.saveUser(mockUserVO);

        verify(userMapper).toDTO(mockUserVO);
        verify(userBO).saveUser(mockUserDTO);
    }

    @Test
    void getUserUsingRestTemplate_ShouldReturnUserVO() {
        String url = "http://localhost:8080/app1/api/users/retrieve/1";
        when(restHelper.getForObject(url, UserVO.class)).thenReturn(mockUserVO);

        UserVO result = userService.getUserUsingRestTemplate(1L);

        verify(restHelper).getForObject(url, UserVO.class);
        assertEquals(mockUserVO, result);
    }

    @Test
    void getUserUsingFeign_ShouldReturnUserVO() {
        when(userFeignClient.getUserById(1L)).thenReturn(mockUserVO);

        UserVO result = userService.getUserUsingFeign(1L);

        verify(userFeignClient).getUserById(1L);
        assertEquals(mockUserVO, result);
    }
}


