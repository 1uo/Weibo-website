package com.luo.springboot.controller;


import com.luo.springboot.entities.user;
import com.luo.springboot.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    userService userService;

    @PostMapping(value = "/usr/addUser")
    public String register(@RequestParam("user") String username,
                           @RequestParam("pass") String password,
                           Map<String,Object> map,
                           HttpSession session){
        //success!
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);

        return "redirect:/administration.html";
    }

    @PostMapping(value = "/deleteUser")
    public String del(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Map<String,Object> map,
                           HttpSession session){
        //success!
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        userService.deleteUser(user);

        return "redirect:/administration.html";
    }

    @PostMapping(value = "/updateUser")
    public String del(@RequestParam("user1") String username,
                      @RequestParam("pass1") String password,
                      @RequestParam("user2") String username2,
                      @RequestParam("pass2") String password2,
                      Map<String,Object> map,
                      HttpSession session){
        //success!

        userService.updateUser(username,password,username2,password2);

        return "redirect:/administration.html";
    }

}
