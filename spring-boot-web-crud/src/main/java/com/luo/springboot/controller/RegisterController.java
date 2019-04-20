package com.luo.springboot.controller;

import com.luo.springboot.entities.user;
import com.luo.springboot.service.userService;
import com.luo.springboot.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {

    @Resource
    userService userService;

    @PostMapping(value = "/usr/register")
    public String register(@RequestParam("user") String username,
                           @RequestParam("pass") String password,
                           Map<String,Object> map,
                           HttpSession session){
        //success!
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);

        return "redirect:/index.html";
    }
}
