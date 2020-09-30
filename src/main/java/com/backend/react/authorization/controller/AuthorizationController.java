package com.backend.react.authorization.controller;

import com.backend.react.authorization.service.AuthorizationService;
import com.backend.react.common.web.ApiResponse;
import com.backend.react.user.model.LoginResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Map;


@RestController
@RequestMapping(value = "/auth")
public class AuthorizationController {


    private AuthorizationService authorizationService;
    private static final Logger log = LoggerFactory.getLogger(AuthorizationController.class);

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping(value = "/login")
    ApiResponse<LoginResponseDTO> loginUser(@RequestHeader(name = "Authorization") String authorization) {
        log.info(authorization);
        return ApiResponse.response(authorizationService.loginUser(authorization));

    }
}
