package com.johncode.fundamentos.springboot.app.caseuse;

import com.johncode.fundamentos.springboot.app.entity.User;
import com.johncode.fundamentos.springboot.app.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User user, Long id) {
        return userService.update(user, id);
    }
}
