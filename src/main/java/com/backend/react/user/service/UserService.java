package com.backend.react.user.service;

import com.backend.react.user.model.User;
import com.backend.react.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public User createUser(User user) {

        String encrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypt);
        return userRepository.save(user);
    }
}
