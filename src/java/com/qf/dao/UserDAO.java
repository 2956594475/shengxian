package com.qf.dao;

import com.qf.pojo.User;

public interface UserDAO {
    void save(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}
