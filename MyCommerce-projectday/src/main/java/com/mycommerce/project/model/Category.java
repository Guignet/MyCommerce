package com.mycommerce.project.model;

import java.util.Objects;

public class Category {
    private int id;
    private String Name;

    public Category(int id, String name) {
        this.id = id;
        Name = name;
    }

    public Category() {
    }

    public Category(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Category {" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Name.equals(category.Name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, Name);
//    }
}
