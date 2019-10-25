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
    /**
     * 根据商品种类查询sku
     */
    List<GoodsSKU> findAllGoodsSKUByType(Integer type_id);
    /**
     * 查询index_promotion(首页促销活动)中所有信息
     */
    List<IndexPromotionBanner> findAllPromotionBanner();
    /**
     * 根据typeID查询表index_type_banner内容
     * 并获取其对应sku的内容
     */
    List<IndexTypeBanner> findImageIndexTypeByTypeId(Integer typeId);

    List<IndexTypeBanner> findTitleIndexTypeByTypeId(Integer typeId);

    List<GoodsSKU> findAllGoodsSKUByTypeAndSortPrice(Integer id);

    List<GoodsSKU> findAllGoodsSKUByTypeAndSortSales(Integer id);

    List<GoodsSKU> findGoodsSKUByType(Integer id);
}
