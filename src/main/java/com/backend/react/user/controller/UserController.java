package com.backend.react.user.controller;

import com.backend.react.user.model.User;
import com.backend.react.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping(value = "/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }


}
