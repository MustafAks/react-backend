package com.backend.react;

import com.backend.react.user.model.User;
import com.backend.react.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication()
public class ReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactApplication.class, args);
    }


    @Bean
    CommandLineRunner initUser(UserService userService) {
        return (args) -> {
            User mustafa = new User("mustafa", "12345", "12345", "Mustafa", true);
            User ahmet = new User("ahmet", "12345", "12345", "Ahmet", true);
            User mehmet = new User("mehmet", "12345", "12345", "Mehmet", true);
            ArrayList<User> list = new ArrayList<>(Arrays.asList(mustafa, mehmet, ahmet));
            for (User user : list) {
                userService.createUser(user);
            }

        };

    }
}
