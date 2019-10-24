package com.qf.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 首页轮播商品展示模型类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexGoodsBanner implements Serializable {

    private Integer id;
    private String image;   // 图片
    private Integer od;     // 展示顺序，如0 1 2 3
    private Integer sku_id; // 商品sku
}
