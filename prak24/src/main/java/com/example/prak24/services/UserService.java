package com.example.prak24.services;

import com.example.prak24.entities.Role;
import com.example.prak24.entities.User;
import com.example.prak24.repositories.RoleRepository;
import com.example.prak24.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user, String key) {

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println("eee");
        return userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserBanStatus(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            if (user.getAccountBan()){
                user.setAccountBan(false);
            }
            else {
                user.setAccountBan(true);
            }
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
    }
}