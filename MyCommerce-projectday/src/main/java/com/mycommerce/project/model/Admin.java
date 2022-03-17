package com.mycommerce.project.model;

public class Admin extends Account{
    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
    }

    public void acceptAccount(Account a){
        a.setActiv(true);
    }
    public void refuseAccount(Account a){
        a.setActiv(false);
    }
}
