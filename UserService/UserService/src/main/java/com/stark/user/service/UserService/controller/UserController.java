package com.stark.user.service.UserService.controller;

import com.stark.user.service.UserService.entity.User;
import com.stark.user.service.UserService.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImp userService;


    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User u = userService.saveUsers(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User u = userService.getUserByID(id);
        return new ResponseEntity<>(u, HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
