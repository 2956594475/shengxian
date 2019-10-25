package com.qf.service;

import com.qf.pojo.*;

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
    /**
     * 根据typeId获取所有文字展示的首页模型
     */
    List<IndexGoodsBanner> findAllIndexBanner();
    /**
     * 根据id查询sku
     */
    GoodsSKU findGoodsSKUById(Integer id);
    /**
     * 根据id获取type
     */
    GoodsType findGoodsTypeById(Integer type_id);
    /**
     * 根据id获取goods
     */
    GoodsSPU findGoodsById(Integer goods_id);
    /**
     * 根据skuid查询Ordergoods
     */
    List<OrderGoods> findOrderGoodsBySkuId(Integer id);
    /**
     * 根据typeid查询sku新品内容
     */
    List<GoodsSKU> findNewGoodsSKUByType(Integer type_id);
    /**
     * 获取所有首页促销活动信息
     */
    List<IndexPromotionBanner> findAllPromotionBanner();
    /**
     * 根据TypeId获取所有图片展示的首页模型
     */
    List<IndexTypeBanner> findImageIndexTypeByTypeId(Integer typeId);
    /**
     * 根据typeId获取所有文字展示的首页模型
     */
    List<IndexTypeBanner> findTitleIndexTypeByTypeId(Integer typeId);
    /**
     * 根据种类id查询sku并按价格排序
     */
    List<GoodsSKU> findGoodsSKUByTypeAndPriceSort(Integer id);
    /**
     * 根据种类id查询sku并按销量排序
     */
    List<GoodsSKU> findGoodsSKUByTypeAndSalesSort(Integer id);
    /**
     * 根据种类id查询sku
     */
    List<GoodsSKU> findGoodsSKUByType(Integer id);
}
