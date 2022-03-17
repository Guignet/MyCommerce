package com.mycommerce.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User extends Account{
    private List<Product> cart = new ArrayList<>();

    public User(String username, String password) {
        super(username, password);
    }

    public User() {

    }

    public void addToCart(Product p){
        cart.add(p);
    }

    public void removeFromCart(Product p){
        cart = cart
                .stream()
                .filter( cp->!cp.equals(p)).collect(Collectors.toList());
        ;
    }

    public void deleteCart(){
        cart.clear();
    }

    public List<Product> seeCart(){
        return cart;
    }
    public List<Product> getCart(){
        return cart;
    }
    public float getTotal(){
        float total=0;
        for (Product p : cart){
            total+= p.getPrice();
        }
        return total;
    }
}
