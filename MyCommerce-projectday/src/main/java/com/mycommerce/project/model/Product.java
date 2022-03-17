package com.mycommerce.project.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private Long id;
    private String name;
    private String content;
    private float price;
    private Category category = null;

    public Product() {
    }

    Product(Long id, String name, String content, float price) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public Product(String name, String content, float price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public Product(String name, String content, float price, Category category) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(content, product.content);
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name= '" + name + '\'' +
                ", content= '" + content + '\'' +
                ", price= " + price +
                ", category= " + category.getName() +
                '}';
    }
}
