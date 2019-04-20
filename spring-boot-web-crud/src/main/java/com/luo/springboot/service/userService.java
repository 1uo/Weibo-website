package com.luo.springboot.service;

import com.luo.springboot.entities.user;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface userService {
    void addUser(user user);
    boolean selectUser(user user);
    List<user> selectAll();
    void deleteUser(user user);
    void updateUser(String user1,String pass1,String user2,String pass2);
}
