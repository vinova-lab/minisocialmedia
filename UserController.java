package com.example.minisocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.minisocial.model.User;
import com.example.minisocial.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/register") public String registerPage() { return "register"; }
    @PostMapping("/register") public String register(@RequestParam String username, @RequestParam String password, @RequestParam(required=false) String profilePic) {
        userService.register(new User(username, password, profilePic == null ? "https://via.placeholder.com/50" : profilePic));
        return "redirect:/login";
    }
    @GetMapping("/login") public String loginPage() { return "login"; }
    @PostMapping("/login") public String login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password) ? "redirect:/" : "login";
    }
}