package com.itheima.service;

import com.itheima.domain.Users;

public interface IUserService {
    void register(String username,String password,String repassword,String telephone);
    Users doLogin(String username);
}
