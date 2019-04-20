package com.luo.springboot.dao;

import com.luo.springboot.entities.Weibo;
import com.luo.springboot.entities.student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WeiboDAO {
    @Insert("insert into weibo(id,content,user,date,likes,dislikes) " +
            "values (null,#{content},#{user},#{date},#{likes},#{dislikes})")
    void addWeibo(Weibo weibo);

    @Select("select * from weibo")
    List<Weibo> getallWeibo();

    @Delete("delete from weibo where user = #{user}")
    void deleteWeibi(Weibo stu);

    @Update("update weibo set likes = #{likes}  where id = #{id} ")
    void addLikes(Weibo weibo);


}
