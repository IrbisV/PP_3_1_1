package com.example.pp_3_1_1_spring_boot.controller;

import com.example.pp_3_1_1_spring_boot.model.User;
import com.example.pp_3_1_1_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";

    }
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";

    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }
    @PostMapping("/user-update/{id}")
    public String updateUser(User user){
        userService.save(user);
        return "redirect:/users";
    }
}
