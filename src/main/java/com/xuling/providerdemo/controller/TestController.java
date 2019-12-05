package com.xuling.providerdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/getService/{info}")
    public String getService(@PathVariable String info){
        return "服务端接收到的信息："+info;
    }
}
