package com.example.PP_3_1_4_REST.controller;

import com.example.PP_3_1_4_REST.model.User;
import com.example.PP_3_1_4_REST.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserServiceImp userService;

    @Autowired
    public AdminRestController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping( "/currentAdmin")
    public User getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    @GetMapping("/admin")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin/{id}")
    public User getUser(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/admin")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/admin")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}

