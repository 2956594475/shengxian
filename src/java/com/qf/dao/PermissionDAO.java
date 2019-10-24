package com.qf.dao;

import java.util.Set;

public interface PermissionDAO {
    public Set<String> queryAllPermissionByUsername(String username);
}
