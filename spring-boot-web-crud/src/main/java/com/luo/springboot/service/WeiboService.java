package com.luo.springboot.service;

import com.luo.springboot.entities.Weibo;
import com.luo.springboot.entities.student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeiboService {
    //@Insert("insert into weibo(content,user,date) values (#{content},#{user}),#{date}")
    void addWeibo(Weibo weibo);

    //@Select("select * from weibo")
    List<Weibo> getallWeibo();

    //@Delete("delete from weibo where user = #{user}")
    void deleteWeibi(Weibo stu);

    void addLikes(Weibo weibo);

}
