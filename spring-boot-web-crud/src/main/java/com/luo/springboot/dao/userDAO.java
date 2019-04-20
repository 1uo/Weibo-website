package com.luo.springboot.dao;

import com.luo.springboot.entities.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userDAO {
    @Insert("insert into myuser(username,password) values (#{username},#{password})")
    void addUser(user user);

    @Select("select * from myuser where username = #{username} AND password = #{password}")
    List<user> selectUser(user user);

    @Select("select * from myuser")
    List<user> selectAll();

    @Delete("delete from myuser where username = #{username} AND password = #{password}")
    void deleteUser(user user);

    @Update("update myuser set username = #{user2} , password = #{pass2} where username = #{user1} AND password = #{pass1}")
    void updateUser(@Param("user1") String user1,@Param("pass1") String pass1,@Param("user2") String user2,@Param("pass2") String pass2);
}
