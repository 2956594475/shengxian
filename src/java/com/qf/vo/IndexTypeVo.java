package com.qf.vo;

import com.qf.pojo.GoodsType;
import com.qf.pojo.IndexTypeBanner;
import lombok.*;

import java.util.List;

/**
 * 首页类型vo类，包含商品种类，总类下图片展示内容和文字展示内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexTypeVo {
    private GoodsType type;
    private List<IndexTypeBanner> image_banners;
    private List<IndexTypeBanner> title_banners;
}
