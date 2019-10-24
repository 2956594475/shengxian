package com.qf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 19:53
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO {
    private String username;
    private String password;
    private Integer remember;
}
