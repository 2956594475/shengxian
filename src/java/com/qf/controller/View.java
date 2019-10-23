package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 11:26
 * @Description:
 */
@Controller
public class View {
    /**
     * 注册页面
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    /**
     * 注册成功页面
     */
    @RequestMapping("/registSuccess")
    public ModelAndView registSuccess(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("title", "注册成功");
        mv.addObject("info", "恭喜你注册成功，接下来前往登陆界面");
        return mv;
    }
}
