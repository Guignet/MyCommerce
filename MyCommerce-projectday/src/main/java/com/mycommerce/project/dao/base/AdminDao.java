package com.mycommerce.project.dao.base;

import com.mycommerce.project.model.Admin;

public interface AdminDao extends Dao<Integer, Admin>{
    public int findByUsername(String username);
}
