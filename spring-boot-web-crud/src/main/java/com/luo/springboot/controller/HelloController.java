package com.luo.springboot.controller;

import com.luo.springboot.dao.WeiboDAO;
import com.luo.springboot.entities.Comments;
import com.luo.springboot.entities.Weibo;
import com.luo.springboot.entities.user;

import com.luo.springboot.service.CommService;
import com.luo.springboot.service.WeiboService;
import com.luo.springboot.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    WeiboService weiboService;

    @Autowired
    userService userService;

    @Autowired
    CommService commService;



    @ResponseBody
    @RequestMapping("/j")
    public String hello(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setUsername("root");
        dataSource.setPassword("Lsc123456");

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        final String[] s = new String[1];
        s[0]="";


        //jdbcTemplate.execute("insert into users(username,password) values('1234','1234');");
        List<user> users = jdbcTemplate.query("select * from users", new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                String name = resultSet.getString("username");
                s[0] = s[0]+name+" ";
               // System.out.println(name);
                 String age = resultSet.getString("password");
                s[0] = s[0]+age+" ";
                return null;
            }
        });

        return s[0];
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","nihao");
        map.put("users", Arrays.asList("zhangsan","lisisisi","lilian","monicaaa"));
        return "success";
    }

    @RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }


    @RequestMapping("register.html")
    public String index2(){
        return "register";
    }

    @RequestMapping("administration.html")
    public String index3(Model model){
        model.addAttribute("alluser",userService.selectAll());
        return "administration";
    }

    @RequestMapping("/mainpage")
    public String mainpage(Model model,HttpSession session){

        List<Weibo> s = weiboService.getallWeibo();
        model.addAttribute("weibolists",s);

        user user = (user) session.getAttribute("loginuser");
        if(user==null){
            return "redirect:/index.html";
        }

        List<user> u = new ArrayList<>();
        u.add(user);
        //System.out.println(u.isEmpty());
        model.addAttribute("LoginUser",u);
        //session.setAttribute("loginuser",user);


       // List<List<Comments>> l;



        //List<Comments> l = commService.showComments()







        return "mainpage";
    }



}
