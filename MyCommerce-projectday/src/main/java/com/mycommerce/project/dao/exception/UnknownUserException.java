package com.mycommerce.project.dao.exception;

public class UnknownUserException extends RuntimeException{
    public UnknownUserException(int id) {
        super("The User with id=" + id + " doesn't exist.");
    }

}
