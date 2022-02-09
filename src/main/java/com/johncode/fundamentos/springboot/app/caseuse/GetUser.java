package com.johncode.fundamentos.springboot.app.caseuse;

import com.johncode.fundamentos.springboot.app.entity.User;

import java.util.List;

public interface GetUser {
    List<User> getAll();

    User getById(Long id);
}
