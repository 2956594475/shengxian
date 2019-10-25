package com.qf.service.impl;

import com.qf.constant.MyConstant;
import com.qf.dao.UserDAO;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Auther: xbh
 * @Date: 2019/10/23 14:46
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public void regist(User user) {
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String s = new Sha256Hash(user.getPassword(), salt, MyConstant.HASH_ITERATIONS).toBase64();
        user.setPassword(s);
        userDAO.save(user);
    }

    @Override
    public boolean CheckUsernameIsExist(String username) {
        User byUsername = userDAO.findByUsername(username);
        if (byUsername == null) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean CheckEmailIsUsed(String email) {
        User byEmail =userDAO.findByEmail(email);
        if (byEmail == null) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public User CheckUserInfoByUsernameOrEmail(String info) {
        User byUsername = userDAO.findByUsername(info);
        if (byUsername != null){
            return byUsername;
        }
        User byEmail = userDAO.findByEmail(info);
        if (byEmail != null){
            return byEmail;
        }
        return null;
    }

}
