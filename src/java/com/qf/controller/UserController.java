package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
}
