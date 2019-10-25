package com.qf.controller;

import com.qf.pojo.GoodsSKU;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.User;
import com.qf.service.GoodsService;
import com.qf.service.RedisService;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Auther: xbh
 * @Date: 2019/10/25 15:34
 * @Description:
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;

    @Autowired
    RedisService redisService;

    /**
     * ajax响应购物车添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo cartAdd(Integer skuId, Integer count, HttpSession session) {
        ResultInfo info = new ResultInfo();
        // 检验商品是否存在
        GoodsSKU sku = goodsService.findGoodsSKUById(skuId);
        if (sku == null) {
            info.setFlag(false);
            info.setMessage("商品不存在");
        }
        // 校验用户是否登录
        Subject subject = SecurityUtils.getSubject();
        User user = userService.CheckUserInfoByUsernameOrEmail((String)subject.getPrincipal());
        if (!subject.isAuthenticated()) {
            info.setFlag(false);
            info.setMessage("用户未登录，请先登录");
        } else {
            // 校验商品库存
            if (sku.getStock() < count) {
                info.setFlag(false);
                info.setMessage("商品库存不足");
            } else {
                redisService.addCartCount(user.getId(), skuId, count);
                info.setFlag(true);
                info.setMessage("添加成功");
                info.setObj(redisService.getAllCartCount(user.getId()));
            }
        }

        return info;
    }

    /**
     * ajax响应购物车更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo cartUpdate(Integer skuId, Integer count, HttpSession session) {
        ResultInfo info = new ResultInfo();

        // 检验商品是否存在
        GoodsSKU sku = goodsService.findGoodsSKUById(skuId);
        if (sku == null) {
            info.setFlag(false);
            info.setMessage("商品不存在");
        }

        // 校验用户是否登录
        Subject subject = SecurityUtils.getSubject();
        User user = userService.CheckUserInfoByUsernameOrEmail((String)subject.getPrincipal());
        if (!subject.isAuthenticated()) {
            info.setFlag(false);
            info.setMessage("用户未登录，请先登录");
        } else {
            // 校验商品库存
            if (sku.getStock() < count) {
                info.setFlag(false);
                info.setMessage("商品库存不足");
            } else {
                redisService.updataCart(user.getId(), skuId, count);
                info.setFlag(true);
                info.setMessage("添加成功");
                info.setObj(redisService.getAllCartCount(user.getId()));
            }
        }

        return info;
    }

    /**
     * ajax响应购物车删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo cartDelete(Integer skuId, HttpSession session) {
        ResultInfo info = new ResultInfo();
        // 校验sku是否存在
        GoodsSKU sku = goodsService.findGoodsSKUById(skuId);
        if (sku == null) {
            info.setFlag(false);
            info.setMessage("无效商品");
            return info;
        }
        // 校验用户登录
        Subject subject = SecurityUtils.getSubject();
        User user = userService.CheckUserInfoByUsernameOrEmail((String)subject.getPrincipal());
        if (!subject.isAuthenticated()) {
            info.setFlag(false);
            info.setMessage("用户未登录，请先登录");
        } else {
            redisService.delCart(user.getId(), skuId);
            info.setFlag(true);
            info.setMessage("删除成功");
            info.setObj(redisService.getAllCartCount(user.getId()));
        }

        return info;
    }
}
