package com.luo.springboot.service;

import com.luo.springboot.dao.commentDAO;
import com.luo.springboot.entities.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommServiceImpl implements CommService {
    @Resource
    commentDAO commentDAO;

    @Override
    public void addComments(Comments comments) {
        Date date = new Date();
        comments.setDate(date.toString());
        commentDAO.addWComments(comments);
    }

    @Override
    public List<Comments> showComments(int id) {
        return commentDAO.showComments(id);
    }
}
