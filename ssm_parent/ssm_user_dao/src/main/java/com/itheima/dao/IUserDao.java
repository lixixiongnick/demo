package com.itheima.dao;

import com.itheima.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface IUserDao {
    @Insert("insert into users(username,password,telephone,state)values(#{username},#{password},#{telephone},#{state})")
    void Register(Users users);
    @Select("select * from users where username = #{username}")
    Users doLogin(String username);
}
