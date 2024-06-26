package com.example.prak23.controllers;

import com.example.prak23.entities.User;
import com.example.prak23.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userReg", new User());
        return "register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping(value = "/regSave", consumes = "application/x-www-form-urlencoded")
    public String addNewUser(@ModelAttribute("userReg") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("Message", "Пароли не совпадают");
            System.out.println("pass");
            return "register";
        }
        if (user.getPassword().length() < 5) {
            model.addAttribute("Message", "Пароль должен содержать минимум 5 символов");
            return "register";
        }
        user.setAccountBan(false);
//        if (!userService.saveUser(user, "new")) {
//            model.addAttribute("Message", "Пользователь с такой почтой уже зарегестрирован");
//            return "register";
//        }
        model.addAttribute("RegFull", "Аккаунт зарегестрирован, теперь можно в него войти!");
        return "register";
    }

}
