package com.qf.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 首页分类商品展示模型类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexTypeBanner implements Serializable {
    private Integer id;
    private Integer display_type;   // 展示类型(0:标题展示；1:图片展示)
    private Integer od;             // 展示顺序
    private Integer sku_id;         // 商品SKU
    private Integer type_id;        // 商品类型
}
