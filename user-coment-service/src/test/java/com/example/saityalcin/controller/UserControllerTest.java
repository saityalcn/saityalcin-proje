package com.example.saityalcin.controller;

import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.entity.User;
import com.example.saityalcin.map.UserMapper;
import com.example.saityalcin.request.UserSaveRequest;
import com.example.saityalcin.request.UserUpdateRequest;
import com.example.saityalcin.service.UserEntityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserEntityService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    void save() {
        User user = new User();
        UserSaveRequest userSaveRequest = new UserSaveRequest("John", "Deck", 120.3, 450.0);
        user.setName("John");

        when(service.save(user)).thenReturn(user);

        UserDTO userDTO = userController.save(userSaveRequest);

        assertEquals(user, userDTO.getName());
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("John");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Doe");

        List<User> userList = Arrays.asList(user1, user2);

        when(service.findAll()).thenReturn(userList);

        List<UserDTO> res = userController.findAll();

        assertEquals(UserMapper.INSTANCE.convertToDTOList(userList), res);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1L);
        user.setName("John");

        UserUpdateRequest updateRequest = new UserUpdateRequest(user.getName());

        when(service.save(user)).thenReturn(user);

        UserDTO userDTO = userController.update(user.getId(), updateRequest);

        assertEquals(user.getName(), userDTO.getName());
    }

    @Test
    void delete() {
        doNothing().when(service).delete(1L);
        userController.delete(1L);
        verify(service, times(1)).delete(1L);
    }

}