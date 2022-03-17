package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.dao.exception.UnknownUserException;
import com.mycommerce.project.model.Admin;
import com.mycommerce.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserDao implements UserDao {

    private static List<User> users = new ArrayList();
    private static int idSequence = 1;

    public MemoryUserDao() {
        if(idSequence==1) {
            this.add(new User("user", "user"));
            this.add(new User("Copkorn", ""));
        }
    }

    @Override
    public User findOne(Integer id) {
        int index = this.getUserIndexById(id);
        if (index > -1) {
            User user = (User) users.get(index);
            return user;
        } else {
            throw new UnknownUserException(id);
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void removeById(Integer id) {
        int index = this.getUserIndexById(id);
        if (index > -1) {
            users.remove(index);
        } else {
            throw new UnknownUserException(id);
        }
    }

    @Override
    public void remove(User obj) {
        this.removeById(obj.getId());
    }

    @Override
    public User update(User obj) {
        int index = this.getUserIndexById(obj.getId());
        if (index > -1) {
            users.set(index, obj);
            return users.get(index);
        } else {
            throw new UnknownUserException(obj.getId());
        }
    }

    @Override
    public int add(User obj) {
        int var1 = idSequence;
        idSequence = idSequence + 1;
        obj.setId(var1);
        users.add(obj);
        return var1;
    }

    private int getUserIndexById(int id) {
        for (int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            if (user.getId()==id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int findByUsername(String username) {
        for (int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            if (user.getUsername().equals(username)) {
                return user.getId();
            }
        }
        return -1;
    }
}
