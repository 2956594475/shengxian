package com.qf.pojo;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品SKU模型类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSKU implements Serializable {

    private Integer id;
    private String name;        // 商品名称
    private String desc;        // 商品描述
    private BigDecimal price;        // 商品价格
    private String unite;       // 商品单位
    private String image;       // 商品图片
    private Integer stock;      // 商品库存
    private Integer sales;      // 商品销量
    private Integer status;     // 商品状态
    private Integer goods_id;   // 商品SPU（标准化产品单元）
    private Integer type_id;    // 商品种类
}
