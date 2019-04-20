package com.luo.springboot.service;



import com.luo.springboot.entities.student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface stuservice {
    boolean addUser(student stu);

    List<student> getallstu();

    void updateStu(student stu);

    void deleteStu(student stu);
}
