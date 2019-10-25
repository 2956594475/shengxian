package com.qf.vo;

import com.qf.pojo.GoodsSKU;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 购物车vo类，包含商品sku，总数量，总金额
 */
@Setter
@Getter
public class CartVo {
    private GoodsSKU sku;          //商品sku
    private Integer count;          //总数量
    private BigDecimal amount;      //总金额
}
