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


    /**
     * 商品列表页面
     */
    @RequestMapping("/goods/list/{ID}")
    public ModelAndView goodsList(@PathVariable("ID") Integer id, Integer sort) {
        ModelAndView mv = new ModelAndView();
        // 获取种类信息
        mv.addObject("types", goodsService.findAllGoodsType());
        // 获取排序: 1(按价格排序) 2(按销量排序) 其他(默认按id排序)
        int s = sort == null ? 0 : sort;
        mv.addObject("type_id", id);
        mv.addObject("sort", s);
        List<GoodsSKU> skus;
        if (s == 1) {
            skus = goodsService.findGoodsSKUByTypeAndPriceSort(id);
        } else if (s == 2) {
            skus = goodsService.findGoodsSKUByTypeAndSalesSort(id);
        } else {
            skus = goodsService.findGoodsSKUByType(id);
        }
        mv.addObject("skus", skus);

        // 获取新品信息
        List<GoodsSKU> new_skus = goodsService.findNewGoodsSKUByType(id);
        mv.addObject("new_sku", new_skus);

        mv.setViewName("list");
        return mv;
    }
}
