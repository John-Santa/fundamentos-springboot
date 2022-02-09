package com.johncode.fundamentos.springboot.app.caseuse;

import com.johncode.fundamentos.springboot.app.entity.User;
import com.johncode.fundamentos.springboot.app.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.save(user);
    }
}
