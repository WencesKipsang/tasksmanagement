package com.kipsang.tasksmanagement.controllers;

import com.kipsang.tasksmanagement.dtos.UserDto;
import com.kipsang.tasksmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto){
        UserDto savedUser =userService.register(userDto);
        return savedUser;
    }
}

