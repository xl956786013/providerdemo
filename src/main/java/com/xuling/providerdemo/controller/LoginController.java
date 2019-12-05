package com.xuling.providerdemo.controller;

import com.xuling.providerdemo.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public User getService(@RequestBody(required = true) User user){
        user.setUserName("aaa");
        return user;
    }
}
