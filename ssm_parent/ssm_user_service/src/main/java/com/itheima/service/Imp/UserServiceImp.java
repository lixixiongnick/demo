package com.itheima.service.Imp;

import com.itheima.dao.IUserDao;
import com.itheima.domain.Users;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public void register(String username, String password, String repassword, String telephone) {
        Users users = new Users();
        if (password != null && repassword!=null && repassword.equals(repassword)){
              users.setPassword(password);
              users.setState(1);
            }else {
            users.setState(0);
        }
        users.setUsername(username);
        users.setTelephone(telephone);
        userDao.Register(users);
    }

    @Override
    public Users doLogin(String username) {
        Users users = userDao.doLogin(username);
        return users;
    }
}
