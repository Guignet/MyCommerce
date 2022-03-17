package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.exception.UnknownCategoryException;
import com.mycommerce.project.model.Category;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryCategoryDao implements CategoryDao {
    private static List<Category> categories = new ArrayList();
    private static int idSequence = 1;

    public MemoryCategoryDao() {
    }

    @Override
    public int add(Category obj) {
        int var1 = idSequence;
        idSequence = idSequence + 1;
        obj.setId(var1);
        categories.add(obj);
        return var1;
    }

    @Override
    public Category update(Category obj) {
        int index = this.getCategoryIndexById(obj.getId());
        if (index > -1) {
            categories.set(index, obj);
            return categories.get(index);
        } else {
            throw new UnknownCategoryException(obj.getId());
        }

    }

    @Override
    public Category findOne(Integer id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            Category category = (Category) categories.get(index);
            return category;
        } else {
            throw new UnknownCategoryException(id);
        }
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void removeById(Integer id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            categories.remove(index);
        } else {
            throw new UnknownCategoryException(id);
        }
    }

    @Override
    public void remove(Category obj) {
        this.removeById(obj.getId());
    }




    private int getCategoryIndexById(int id) {
        for (int i = 0; i < categories.size(); ++i) {
            Category category = categories.get(i);
            if (category.getId()==id) {
                return i;
            }
        }

        return -1;
    }
}
