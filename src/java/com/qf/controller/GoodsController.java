package com.qf.controller;

import com.qf.pojo.GoodsSKU;
import com.qf.pojo.OrderGoods;
import com.qf.service.GoodsService;
import com.qf.service.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: xbh
 * @Date: 2019/10/24 11:31
 * @Description:
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisService redisService;
    /**
     * 商品详情页面
     */
    @RequestMapping("/goods/{ID}")
    public ModelAndView detailView(@PathVariable("ID") Integer id, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        // 获取种类信息
        mv.addObject("types", goodsService.findAllGoodsType());
        // 根据id查询sku
        GoodsSKU sku = goodsService.findGoodsSKUById(id);
        mv.addObject("goods_sku", sku);
        // 获取所属种类
        mv.addObject("type", goodsService.findGoodsTypeById(sku.getType_id()));
        // 获取对应SPU
        mv.addObject("goods_spu", goodsService.findGoodsById(sku.getGoods_id()));
        // 获取商品评论信息
        List<OrderGoods> skuOrder = goodsService.findOrderGoodsBySkuId(sku.getId());
        mv.addObject("sku_orders", skuOrder);
        // 获取新品信息
        List<GoodsSKU> new_skus = goodsService.findNewGoodsSKUByType(sku.getType_id());
        mv.addObject("new_sku", new_skus);

        /*
        // 获取用户购物车中商品的数目
        Integer cart_count = 0;
        // 如果用户已经登录，则获取用户的购物车数量，且添加历史浏览记录
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // 获取购物车数目
            cart_count = redisService.getAllCartCount(user.getId());
            // 添加历史浏览记录
            redisService.addHistory(user.getId(), id);
        }
        mv.addObject("cartCount", cart_count);
         */
        mv.setViewName("detail");
        return mv;
    }
}
