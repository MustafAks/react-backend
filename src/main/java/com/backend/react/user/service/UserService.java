package com.backend.react.user.service;

import com.backend.react.common.exception.ExceptionEnum;
import com.backend.react.common.exception.ExceptionFactory;
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
        if (user.getUsername() == null) {
            ExceptionFactory.throwException("username", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getPassword() == null) {
            ExceptionFactory.throwException("password", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getRepeatPassword() == null) {
            ExceptionFactory.throwException("repeatpassword", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getDisplayName() == null) {
            ExceptionFactory.throwException("displayname", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        String encrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypt);
        return userRepository.save(user);
    }
}
