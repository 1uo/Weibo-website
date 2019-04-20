package com.luo.springboot.dao;

import com.luo.springboot.entities.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface commentDAO {
    @Insert("insert into comments(id,comment,user,date) " +
            "values (#{id},#{comment},#{user},#{date})")
    void addWComments(Comments comments);

    @Select("select * from comments where id = #{id}")
    List<Comments> showComments(@RequestParam("id") int id);
}
