package com.example.prak24;

import com.example.prak24.entities.User;
import com.example.prak24.repositories.UserRepository;

import com.example.prak24.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Captor
    ArgumentCaptor<User> captor;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    void getUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("username1", "name1", "lastName1", "phone1", "email1", "password1"));
        userList.add(new User("username2", "name2", "lastName2", "phone2", "email2", "password2"));

        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getUsers();

        verify(userRepository).findAll();

        assertEquals(userList, result);
    }

    @Test
    void saveOrUpdate() {
        User user = new User("username", "name", "lastName", "phone", "email", "password");

        when(userRepository.save(any())).thenReturn(user);

        User savedUser = userService.saveUser(user, "new");

        verify(userRepository).save(captor.capture());
        assertEquals(user, captor.getValue());

        assertEquals(user, savedUser);
    }
}


