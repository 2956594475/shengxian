package com.qf.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 首页促销活动模型类
 */
@Setter
@Getter
public class IndexPromotionBanner implements Serializable {

    private Integer id;
    private String name;    // 活动名称
    private String url;     // 活动链接
    private String image;   // 活动图片
    private Integer od;     // 展示顺序

}
