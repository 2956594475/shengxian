package com.qf.dao;

import com.qf.pojo.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: xbh
 * @Date: 2019/10/24 11:51
 * @Description:
 */
public interface GoodsDao {
    /**
     * 查询所有type
     */
    List<GoodsType> findAllGoodsType();
    /**
     * 查询index_banner(首页轮播商品)中信息
     */
    List<IndexGoodsBanner> findAllIndexBanner();
    /**
     * 根据id查询sku表
     */
    GoodsSKU findGoodsSKUById(Integer id);
    /**
     * 根据id查询goods_type
     */
    GoodsType findGoodsTypeById(Integer type_id);
    /**
     * 根据id查询goods
     */
    GoodsSPU findGoodsById(Integer goods_id);
    /**
     * 根据skuid查询order_goods表内容
     */
    List<OrderGoods> findOrderGoodsBySkuId(Integer id);

    List<GoodsSKU> findAllGoodsSKUByType(Integer type_id);

    List<IndexPromotionBanner> findAllPromotionBanner();
}
