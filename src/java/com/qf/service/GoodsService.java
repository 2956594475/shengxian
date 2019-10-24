package com.qf.service;

import com.qf.pojo.GoodsType;

import java.util.List;

/**
 * @Auther: xbh
 * @Date: 2019/10/24 11:49
 * @Description:
 */
public interface GoodsService {
    /**
     * 获取所有商品种类
     */
    List<GoodsType> findAllGoodsType();
}
