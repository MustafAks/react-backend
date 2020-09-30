package com.backend.react.user.service;

import com.backend.react.common.exception.ExceptionEnum;
import com.backend.react.common.exception.ExceptionFactory;
import com.backend.react.user.model.User;
import com.backend.react.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserServiceImp {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createUser(User user) {
        validUser(user);
        String encrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypt);
        return userRepository.save(user);
    }


    private void validUser(User user) {
        if (user.getUserName() == null) {
            ExceptionFactory.throwException("userName", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getPassword() == null) {
            ExceptionFactory.throwException("password", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getRepeatPassword() == null) {
            ExceptionFactory.throwException("repeatPassword", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }
        if (user.getDisplayName() == null) {
            ExceptionFactory.throwException("displayName", ExceptionEnum.BAD_REQUEST_MANDATORY);
        }

        User isUnique = userRepository.findByUserName(user.getUserName());
        if (isUnique != null) {
            ExceptionFactory.throwException("userName", ExceptionEnum.ALREADY_ADDED_FAILURE);
        }

    }

}
