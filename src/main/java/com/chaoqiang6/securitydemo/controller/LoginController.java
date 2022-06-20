package com.chaoqiang6.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping("login")
    public String login(){
        System.out.println("执行登陆方法");
        return "redirect:main.html";
    }

}
