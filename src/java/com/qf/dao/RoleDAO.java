package com.qf.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleDAO {
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
