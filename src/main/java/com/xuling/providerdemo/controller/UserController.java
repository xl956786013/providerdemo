package com.xuling.providerdemo.controller;

import com.xuling.providerdemo.model.User;
import com.xuling.providerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserById")
    public User getService(@RequestBody(required = true) Integer userId){
        return userService.getUserById(userId);
    }
}
