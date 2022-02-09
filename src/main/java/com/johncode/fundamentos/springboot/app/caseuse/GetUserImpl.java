package com.johncode.fundamentos.springboot.app.caseuse;

import com.johncode.fundamentos.springboot.app.entity.User;
import com.johncode.fundamentos.springboot.app.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser {

    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public User getById(Long id) {
        return userService.getUserById(id);
    }
}
