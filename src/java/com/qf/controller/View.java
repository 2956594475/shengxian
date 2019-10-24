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
     * 去头部
     */
    @RequestMapping("/header")
    public String header(){
        return "header";
    }
    /**
     * 去尾部
     */
    @RequestMapping("/footer")
    public String footer(){
        return "footer";
    }
    /**
     * 去searchBar
     */
    @RequestMapping("/searchBar")
    public String searchBar(){
        return "searchBar";
    }
    /**
     * 去404
     */
    @RequestMapping("/go404")
    public String go404(){
        return "404";
    }
    /**
     * 去主页
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    /**
     * 登陆页面
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
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

    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
