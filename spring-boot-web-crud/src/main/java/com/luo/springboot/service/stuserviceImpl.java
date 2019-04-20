package com.luo.springboot.service;


import com.luo.springboot.dao.studentDAO;
import com.luo.springboot.entities.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class stuserviceImpl implements stuservice {

    @Resource
    private com.luo.springboot.dao.studentDAO studentDAO;
    @Override
    public boolean addUser(student stu) {
        boolean flag = false;
        try {
            studentDAO.addUser(stu);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<student> getallstu() {
        return (List<student>) studentDAO.getallstu();
    }

    @Override
    public void updateStu(student stu) {
        studentDAO.updateStu(stu);
    }

    @Override
    public void deleteStu(student stu) {
        studentDAO.deleteStu(stu);
    }
}
