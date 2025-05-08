package com.example.ChronoExplorerBackend.Controller;

import com.example.ChronoExplorerBackend.Entity.User;
import com.example.ChronoExplorerBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.getUserByUsername(user.getUsername());
    }
}
