package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.pojo.GoodsType;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
