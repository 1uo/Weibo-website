package com.luo.springboot.controller;

import com.luo.springboot.entities.Comments;
import com.luo.springboot.entities.Weibo;
import com.luo.springboot.entities.student;
import com.luo.springboot.entities.user;
import com.luo.springboot.service.CommService;
import com.luo.springboot.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WeiboController {
    @Autowired
    WeiboService weiboService;

    @Autowired
    CommService commService;

    @RequestMapping(value = "/showComment")
    public String showComment(Model model, int id){


        List<Weibo> s = weiboService.getallWeibo();
        model.addAttribute("weibolists",s);


        List<Comments> s2 = commService.showComments(id);
        System.out.println(s2.isEmpty()+" 1111"+s2.size());
        model.addAttribute("commentlists",s2);
        
        return "redirect:/mainpage";
    }


    @RequestMapping(value = "/addComment")
    public String addComment(Model model, Comments comments, HttpSession session){
        user user1 = (user)session.getAttribute("loginuser");
        comments.setUser(user1.getUsername());
        commService.addComments(comments);
        List<Weibo> s = weiboService.getallWeibo();
        model.addAttribute("weibolists",s);
        return "redirect:/mainpage";
    }

    @RequestMapping(value = "/addWeibo")
    public String addWeibo(Model model, Weibo weibo, HttpSession session){
        weibo.setLikes(0);
        weibo.setDislikes(0);
        user user1 = (user)session.getAttribute("loginuser");
        weibo.setUser(user1.getUsername());
        weiboService.addWeibo(weibo);
        List<Weibo> s = weiboService.getallWeibo();
        model.addAttribute("weibolists",s);
        return "redirect:/mainpage";
    }

    @RequestMapping(value = "/addLikes")
    public String addLikes(Model model, Weibo weibo){
        weibo.setLikes(weibo.getLikes()+1);
        weiboService.addLikes(weibo);
        List<Weibo> s = weiboService.getallWeibo();
        model.addAttribute("weibolists",s);
        return "redirect:/mainpage";
    }
}
