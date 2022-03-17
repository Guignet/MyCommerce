package com.mycommerce.project.dao.exception;

public class UnknownCategoryException extends RuntimeException {
    public UnknownCategoryException(int id) {
        super("The Category with id=" + id + " doesn't exist.");
    }
}
