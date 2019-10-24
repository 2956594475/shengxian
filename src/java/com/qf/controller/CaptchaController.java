package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.utils.Captcha1;
import com.qf.utils.Captcha2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 17:18
 * @Description:
 */
@Controller
public class CaptchaController {
    @RequestMapping("/captcha1")
    public void captcha1(HttpSession session, HttpServletResponse res, HttpServletRequest req) throws IOException {
        Captcha1.generateCaptcha(req,res);
    }

    @RequestMapping("/captcha2")
    public void captcha2(HttpSession session, HttpServletResponse res, HttpServletRequest req) throws IOException {
        Captcha2.generateCaptcha(req,res);
    }

    @RequestMapping("/checkcaptcha")
    @ResponseBody
    public Map<String, Integer> checkcaptcha(@RequestBody Map captchaInput, HttpSession session) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String captcha = (String)session.getAttribute("captcha");
        String inputCaptcha = (String)captchaInput.get("captchaInput");
        if (inputCaptcha.equalsIgnoreCase(captcha)){
            map.put("result", 1);
        }else{
            map.put("result", 0);
        }
        return map;
    }
}
