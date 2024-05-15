package com.example.prak23.controllers;

import com.example.prak23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;

//    @GetMapping("/admin")
//    public String adminPage(Model model){
//        model.addAttribute("users", userService.findAll());
//        return "admin";
//    }


    @PostMapping("/admin/delete")
    public String deleteUser(@RequestParam("userId") Long userId, RedirectAttributes redirectAttributes) {
        userService.deleteUser(userId);
        redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully");
        return "redirect:/admin";
    }

    @PostMapping("/admin/bans")
    public String bans(@RequestParam("userId") Long userId, RedirectAttributes redirectAttributes) {
        userService.updateUserBanStatus(userId);
        return "redirect:/admin";
    }


}
