package com.backend.react.authorization.service;


import com.backend.react.user.model.LoginResponseDTO;
import com.backend.react.user.model.User;
import com.backend.react.user.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponseDTO loginUser(String authorization) {
        String base64Encoded = authorization.split("Basic")[1];
        String decoded = new String(Base64.decodeBase64(base64Encoded.getBytes()));
        String[] parts = decoded.split(":");
        String username = parts[0];
        User user = userRepository.findByUserName(username);
        LoginResponseDTO response = new LoginResponseDTO(user.getUserName(), user.getDisplayName(), user.getImage());
        return response;
    }

}
