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

//    @BeforeEach
//    void setUp() {
//        userService = new UserService(userRepository, passwordEncoder); // Передаем мок PasswordEncoder в конструктор UserServiceImpl
//    }

    @Test
    void getUsers() {
        // Создание списка пользователей для возврата из репозитория
        List<User> userList = new ArrayList<>();
        userList.add(new User("username1", "name1", "lastName1", "phone1", "email1", "password1"));
        userList.add(new User("username2", "name2", "lastName2", "phone2", "email2", "password2"));

        // Макет репозитория для возврата списка пользователей при вызове метода findAll()
        when(userRepository.findAll()).thenReturn(userList);

        // Вызов метода getUsers() сервиса
        List<User> result = userService.getUsers();

        // Проверка, что метод findAll() был вызван у репозитория
        verify(userRepository).findAll();

        // Проверка, что возвращенный список пользователей совпадает с ожидаемым списком
        assertEquals(userList, result);
    }

    @Test
    void saveOrUpdate() {
        // Создание пользователя для сохранения
        User user = new User("username", "name", "lastName", "phone", "email", "password");

        // Макет репозитория для возврата сохраненного пользователя при вызове метода save()
        when(userRepository.save(any())).thenReturn(user);

        // Вызов метода saveOrUpdate() сервиса
        User savedUser = userService.saveUser(user, "new");

        // Проверка, что метод save() был вызван у репозитория с правильным аргументом
        verify(userRepository).save(captor.capture());
        assertEquals(user, captor.getValue());

        // Проверка, что возвращенный пользователь совпадает с ожидаемым пользователем
        assertEquals(user, savedUser);
    }
}


