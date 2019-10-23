package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 11:30
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;    // 用户名
    private String password;    // 密码
    private String email;       // 邮箱
    private String salt;        //盐
}
