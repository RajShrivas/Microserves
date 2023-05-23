package com.stark.user.service.UserService.services;

import com.stark.user.service.UserService.entity.User;

import java.util.List;

public interface UserService {

    //create
    User saveUsers(User user);

    //read
    List<User> getAllUsers();

    //get user by id
    User getUserByID(Long id);
}
