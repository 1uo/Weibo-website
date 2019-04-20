package com.luo.springboot.service;

import com.luo.springboot.dao.userDAO;
import com.luo.springboot.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl implements userService{
    @Resource
    com.luo.springboot.dao.userDAO userDAO;

    @Override
    public void addUser(user user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean selectUser(user user) {

//        System.out.println(userDAO.selectUser(user));
//        System.out.println(userDAO.selectUser(user).isEmpty());

        return !userDAO.selectUser(user).isEmpty();

    }

    @Override
    public List<user> selectAll() {
        return userDAO.selectAll();
    }

    @Override
    public void deleteUser(user user) {
        //System.out.println(user.getPassword());
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(String user1, String pass1, String user2, String pass2) {
        System.out.println(user1+user2+pass1+pass2);
        userDAO.updateUser(user1,pass1,user2,pass2);
    }
}
