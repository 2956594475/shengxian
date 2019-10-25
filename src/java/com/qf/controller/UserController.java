package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.RedisService;
import com.qf.service.UserService;
import com.qf.vo.CartVo;
import com.qf.vo.UserLoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 14:31
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Map<String, Integer> map = new HashMap<>();
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/registerHandle")
    @ResponseBody
    public Map<String, Integer> registerHandle(@RequestBody User user){
        Boolean user2 = userService.CheckUsernameIsExist(user.getUsername());
        if (user2 == true){
            map.put("result", 0);
            return map;
        }
        boolean email = userService.CheckEmailIsUsed(user.getEmail());
        if (email == true){
            map.put("result", 0);
            return map;
        }
        userService.regist(user);
        map.put("result", 1);
        return map;
    }

    @PostMapping("/loginHandle")
    @ResponseBody
    public Map<String, Integer> loginHandle(@RequestBody UserLoginVO userLoginVO){

        if(userService.CheckUsernameIsExist(userLoginVO.getUsername()) || userService.CheckEmailIsUsed(userLoginVO.getUsername())){
            map.put("result", 1);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userLoginVO.getUsername(), userLoginVO.getPassword());
            if (userLoginVO.getRemember() == 1){
                token.setRememberMe(true);
            }
            subject.login(token);
            return map;
        }
        map.put("result", 0);
        return map;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(){
        SecurityUtils.getSubject().logout();
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }


    /**
     * 用户购物车页面
     */
    @RequestMapping("/cart")
    public ModelAndView cartView(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        // 获取登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = userService.CheckUserInfoByUsernameOrEmail((String)subject.getPrincipal());
        // 获取用户购物车中的信息
        List<CartVo> cartvos = redisService.getAllCartInfo(user.getId());
        Integer count = redisService.getAllCartCount(user.getId());

        mv.addObject("carts", cartvos);
        mv.addObject("count", count);
        mv.setViewName("cart");
        return mv;
    }
}
