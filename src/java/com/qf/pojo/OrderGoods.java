package com.qf.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 商品订单类
 */
@Setter
@Getter
public class OrderGoods {
    private Integer id;         // 主键
    private Integer count;      // 商品数目
    private BigDecimal price;        // 商品价格
    private String comment;     // 评论
    private String order_id;    // 订单id
    private Integer sku_id;     // sku id
    private GoodsSKU sku;
}
