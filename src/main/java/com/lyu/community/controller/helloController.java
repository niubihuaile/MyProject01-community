package com.lyu.community.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping("/fuck")
    public String hello(){
        return "fuck world";
    }
}
