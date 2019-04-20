package com.luo.springboot.service;

import com.luo.springboot.dao.WeiboDAO;
import com.luo.springboot.entities.Weibo;
import com.luo.springboot.entities.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService{
    @Resource
    WeiboDAO weiboDAO;

    @Override
    public void addWeibo(Weibo weibo) {
        Date date = new Date();
        weibo.setDate(date.toString());
        weiboDAO.addWeibo(weibo);
    }

    @Override
    public List<Weibo> getallWeibo() {
        return weiboDAO.getallWeibo();
    }

    @Override
    public void deleteWeibi(Weibo stu) {
        weiboDAO.deleteWeibi(stu);
    }

    @Override
    public void addLikes(Weibo weibo) {
        //System.out.println(weibo.getLikes());
        weiboDAO.addLikes(weibo);
    }
}
