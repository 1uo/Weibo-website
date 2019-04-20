package com.luo.springboot.controller;

import com.luo.springboot.entities.user;
import com.luo.springboot.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    userService userService;

    @PostMapping(value = "/usr/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        Map<String,Object> map,
                        HttpSession session){

        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        //userService.addUser(user);



        //success!
        if("admin".equals(username) && "123456".equals(password)){

            return "redirect:/administration.html";
        }else if(userService.selectUser(user)){
            List<user> u = new ArrayList<>();
            u.add(user);
            System.out.println(u.isEmpty());
            model.addAttribute("LoginUser",u);
            session.setAttribute("loginuser",user);
            return "redirect:/mainpage";
        }else {
            map.put("msg","error.");
            return "index";
        }

    }


}
