package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 14:43
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo {
    private boolean flag;
    private String message;
    private Object obj;
}
