package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品SPU模型类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSPU implements Serializable {
    private Integer id;
    private String name;    // 商品名称
    private String detail;  // 商品详情
}
