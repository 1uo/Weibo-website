package com.luo.springboot.controller;


import com.luo.springboot.entities.student;
import com.luo.springboot.service.stuservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class stucontroller {

    @Resource
    private com.luo.springboot.service.stuservice stuservice;

    @RequestMapping(value = "/add")
    public String addStu(student stu){
//        student stu = new student();
//        stu.setsid("12345");
//        stu.setsname("54321");
        System.out.println(111);
        stuservice.addUser(stu);
        return "redirect:/mainpage";
    }

    @RequestMapping(value = "/delete")
    public String deleteStu(student stu){
        stuservice.deleteStu(stu);
        return "redirect:/mainpage";
    }

    @RequestMapping(value = "/update")
    public String updateStu(student stu){
        stuservice.updateStu(stu);
        return "redirect:/mainpage";
    }


    @RequestMapping(value = "/all")
    public String getallstu(Model model){
        List<student> s = stuservice.getallstu();

        model.addAttribute("borrowingBooksList", s);
        return "test1.html";
    }

    @RequestMapping(value = "/1")
    public String allStu(Model model){
        List<student> s = stuservice.getallstu();

        model.addAttribute("borrowingBooksList", s);

        return "test1.html";
    }



//    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "main.html";
//    }
//
//    @RequestMapping(value = "/1")
//    public String mian1(){
//
//        return "/main";
//    }
//
//    @RequestMapping(value = "/2")
//    public String mian2(){
//
//        return "/main";
//    }
//
//    @RequestMapping(value = "/3")
//    public String mian3(){
//
//        return "/main.html";
//    }



}
