package com.qf.service;

import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 14:46
 * @Description:
 */
@Service
public interface UserService {
    /**
     * 注册方法
     */
    void regist(User user);
    /**
     * 检查用户名是否存在
     */
    boolean CheckUsernameIsExist(String username);
    /**
     * 检查邮箱是否已经占用
     */
    boolean CheckEmailIsUsed(String email);
    /**
     * 邮箱与用户名查询用户信息
     */
    User CheckUserInfoByUsernameOrEmail(String info);
}
