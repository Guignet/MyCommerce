package com.mycommerce.project.dao.base;
import java.util.List;

public interface Dao<K,T> {
    public T findOne(K id);
    public List<T> findAll();
    public void removeById(K id);
    public void remove(T obj);
    public T update(T obj);
    public int add(T obj);

}