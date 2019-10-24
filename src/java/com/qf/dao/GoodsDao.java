package com.qf.dao;

import com.qf.pojo.GoodsType;
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
}
