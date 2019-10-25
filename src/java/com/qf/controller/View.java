package com.qf.controller;


import com.qf.pojo.GoodsType;
import com.qf.vo.IndexTypeVo;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 11:26
 * @Description:
 */
@Controller
public class View {

    @Autowired
    private GoodsService goodsService;

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
    @RequestMapping({"/index", "/"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        Map<String, List> map = new HashMap<>();
        List<IndexTypeVo> typeVos = new ArrayList<>();
        // 获取商品的种类信息
        List<GoodsType> types = goodsService.findAllGoodsType();
        // 获取首页轮播商品信息
        map.put("goodsBanners", goodsService.findAllIndexBanner());
        // 获取首页促销活动信息
        map.put("promotionBanners", goodsService.findAllPromotionBanner());
        for (GoodsType type : types) {
            IndexTypeVo vo = new IndexTypeVo();
            vo.setType(type);
            vo.setImage_banners(goodsService.findImageIndexTypeByTypeId(type.getId()));
            vo.setTitle_banners(goodsService.findTitleIndexTypeByTypeId(type.getId()));
            typeVos.add(vo);
        }
        map.put("typeVos", typeVos);
        mv.addAllObjects(map);
        mv.setViewName("index");
        return mv;
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
}
