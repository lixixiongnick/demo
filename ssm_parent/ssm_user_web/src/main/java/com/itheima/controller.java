package com.itheima;

import com.itheima.domain.Users;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class controller {
    @Autowired
    private IUserService userService;
    @RequestMapping("/doRegister")
    public ModelAndView Register(String username,String password,String repassword,String telephone){
        ModelAndView mv = new ModelAndView();
        userService.register(username,password,repassword,telephone);
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/doLogin")
    public ModelAndView doLogin(String username,String password){
        Users users = userService.doLogin(username);
        ModelAndView mv = new ModelAndView();
       if (users.getPassword().equals(password)){
           mv.setViewName("success");
       }else{
           mv.setViewName("defeated");
       }
       mv.addObject("user",users);
       return mv;
    }
}
