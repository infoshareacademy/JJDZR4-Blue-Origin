package com.infoshareacademy.controllers;

import com.infoshareacademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "Users";
    }
}
