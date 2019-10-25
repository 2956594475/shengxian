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
}
