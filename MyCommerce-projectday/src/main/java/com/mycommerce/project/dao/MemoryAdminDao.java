package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.AdminDao;
import com.mycommerce.project.dao.exception.UnknownAdminException;
import com.mycommerce.project.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class MemoryAdminDao implements AdminDao {

    private static List<Admin> admins = new ArrayList();
    private static int idSequence = 1;

    public MemoryAdminDao() {
        if(idSequence==1){
            this.add(new Admin("sudo","sudo"));
            this.add(new Admin("sudoku","sudoku"));

        }
    }

    @Override
    public Admin findOne(Integer id) {
        int index = this.getAdminIndexById(id);
        if (index > -1) {
            Admin admin = (Admin) admins.get(index);
            return admin;
        } else {
            throw new UnknownAdminException(id);
        }
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

    @Override
    public void removeById(Integer id) {
        int index = this.getAdminIndexById(id);
        if (index > -1) {
            admins.remove(index);
        } else {
            throw new UnknownAdminException(id);
        }
    }

    @Override
    public void remove(Admin obj) {
        this.removeById(obj.getId());
    }

    @Override
    public Admin update(Admin obj) {
        int index = this.getAdminIndexById(obj.getId());
        if (index > -1) {
            admins.set(index, obj);
            return admins.get(index);
        } else {
            throw new UnknownAdminException(obj.getId());
        }
    }

    @Override
    public int add(Admin obj) {
        int var1 = idSequence;
        idSequence = idSequence + 1;
        obj.setId(var1);
        admins.add(obj);
        return var1;
    }

    private int getAdminIndexById(int id) {
        for (int i = 0; i < admins.size(); ++i) {
            Admin admin = admins.get(i);
            if (admin.getId()==id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int findByUsername(String username) {
        for (int i = 0; i < admins.size(); ++i) {
            Admin admin = admins.get(i);
            if (admin.getUsername().equals(username)) {
                return admin.getId();
            }
        }
        return -1;
    }
}
