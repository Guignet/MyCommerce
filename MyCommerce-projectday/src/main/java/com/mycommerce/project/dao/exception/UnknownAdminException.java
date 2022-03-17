package com.mycommerce.project.dao.exception;

public class UnknownAdminException extends RuntimeException{
    public UnknownAdminException(int id) {
        super("The Admin with id=" + id + " doesn't exist.");
    }

}
