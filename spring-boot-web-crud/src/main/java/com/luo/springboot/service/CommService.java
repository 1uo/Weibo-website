package com.luo.springboot.service;


import com.luo.springboot.entities.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommService {

    void addComments(Comments comments);

    List<Comments> showComments(int id);

}
