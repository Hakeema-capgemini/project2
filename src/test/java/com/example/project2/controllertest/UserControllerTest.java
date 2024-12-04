package com.example.project2.controllertest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.project2.controller.UserController;
import com.example.project2.service.UserService;
import com.example.project2.vo.UserVO;
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    private UserVO userVO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("Rizwana");
        userVO.setAge(24);
    }

    @Test
    void testGetUserUsingFeign() throws Exception {
        when(userService.getUserUsingFeign(1L)).thenReturn(userVO);

        mockMvc.perform(get("/app2/api/user/feign/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Rizwana"))
                .andExpect(jsonPath("$.age").value(24));

        verify(userService).getUserUsingFeign(1L);
    }

    @Test
    void testGetUserUsingRestTemplate() throws Exception {
        when(userService.getUserUsingRestTemplate(1L)).thenReturn(userVO);

        mockMvc.perform(get("/app2/api/user/rest/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Rizwana"))
                .andExpect(jsonPath("$.age").value(24));

        verify(userService).getUserUsingRestTemplate(1L);
    }
}
