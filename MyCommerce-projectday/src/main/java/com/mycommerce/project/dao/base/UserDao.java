package com.mycommerce.project.dao.base;

import com.mycommerce.project.model.User;

public interface UserDao extends Dao<Integer, User> {
    public int findByUsername(String username);
}
