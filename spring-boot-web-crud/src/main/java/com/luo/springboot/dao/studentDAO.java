package com.luo.springboot.dao;


import com.luo.springboot.entities.student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studentDAO {
    @Insert("insert into student(sname,sid) values (#{sname},#{sid})")
    void addUser(student stu);

    @Select("select * from student")
     List<student> getallstu();

    @Delete("delete from student where sid = #{sid} AND sname = #{sname}")
    void deleteStu(student stu);

    @Update("update student set sname=#{sname} where sid=#{sid}")
    void updateStu(student stu);

}
