package com.qf.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 商品种类模型类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType implements Serializable {

    private Integer id;
    private String name;    // 种类名称
    private String logo;    // 标识，用于控制雪碧图
    private String image;   // 种类的类型图片
}
