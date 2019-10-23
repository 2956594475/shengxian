package com.qf;

import com.qf.dao.UserDAO;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 15:54
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserService userService;
    @Test
    public void testService(){
        boolean xbh123456 = userService.CheckUsernameIsExist("xbh123456");
        System.out.println(xbh123456);
    }
    @Test
    public void testDao(){
        userDAO.save(new User(1, "xbh123456", "xbh123456", "xbh123456@qq.com", "xbh123456"));
        User xbh1234561 = userDAO.findByUsername("xbh123456");
        System.out.println(xbh1234561);
    }
}
