package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.pojo.*;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xbh
 * @Date: 2019/10/24 11:50
 * @Description:
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<GoodsType> findAllGoodsType() {
        return goodsDao.findAllGoodsType();
    }

    @Override
    public List<IndexGoodsBanner> findAllIndexBanner() {
        return goodsDao.findAllIndexBanner();
    }

    @Override
    public GoodsSKU findGoodsSKUById(Integer id) {
        return goodsDao.findGoodsSKUById(id);
    }

    @Override
    public GoodsType findGoodsTypeById(Integer type_id) {
        return goodsDao.findGoodsTypeById(type_id);
    }

    @Override
    public GoodsSPU findGoodsById(Integer goods_id) {
        return goodsDao.findGoodsById(goods_id);
    }

    @Override
    public List<OrderGoods> findOrderGoodsBySkuId(Integer id) {
        return goodsDao.findOrderGoodsBySkuId(id);
    }

    @Override
    public List<GoodsSKU> findNewGoodsSKUByType(Integer type_id) {
        List<GoodsSKU> new_sku = new ArrayList<>();
        List<GoodsSKU> goods_sku = goodsDao.findAllGoodsSKUByType(type_id);
        int i = 0;
        for (GoodsSKU sku : goods_sku) {
            if (i >= 2) {
                break;
            }
            new_sku.add(sku);
            i++;
        }
        return new_sku;
    }

    @Override
    public List<IndexPromotionBanner> findAllPromotionBanner() {
        return goodsDao.findAllPromotionBanner();
    }

    @Override
    public List<IndexTypeBanner> findImageIndexTypeByTypeId(Integer typeId) {
        List<IndexTypeBanner> igb = goodsDao.findImageIndexTypeByTypeId(typeId);
        for (IndexTypeBanner banner : igb) {
            GoodsSKU sku = goodsDao.findGoodsSKUById(banner.getSku_id());
            banner.setSku(sku);
        }
        return igb;
    }

    @Override
    public List<IndexTypeBanner> findTitleIndexTypeByTypeId(Integer typeId) {
        List<IndexTypeBanner> igb = goodsDao.findTitleIndexTypeByTypeId(typeId);
        for (IndexTypeBanner banner : igb) {
            GoodsSKU sku = goodsDao.findGoodsSKUById(banner.getSku_id());
            banner.setSku(sku);
        }
        return igb;
    }

    @Override
    public List<GoodsSKU> findGoodsSKUByTypeAndPriceSort(Integer id) {
        return goodsDao.findAllGoodsSKUByTypeAndSortPrice(id);
    }

    @Override
    public List<GoodsSKU> findGoodsSKUByTypeAndSalesSort(Integer id) {
        return goodsDao.findAllGoodsSKUByTypeAndSortSales(id);
    }

    @Override
    public List<GoodsSKU> findGoodsSKUByType(Integer id) {
        return goodsDao.findGoodsSKUByType(id);
    }
}
