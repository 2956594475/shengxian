package com.qf.service.impl;
import com.qf.dao.RoleDAO;
import com.qf.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDAO roleDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleDAO.queryAllRolenameByUsername(username);
    }
}
