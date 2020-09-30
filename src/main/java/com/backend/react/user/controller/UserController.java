package com.backend.react.user.controller;

import com.backend.react.common.web.ApiResponse;
import com.backend.react.user.model.User;
import com.backend.react.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/")
    public ApiResponse<User> createUser(User user) {
        return ApiResponse.response(userService.createUser(user));
    }


}
