package com.codegym.book_borrow.service;

import java.util.List;

public interface Service<T> {
    boolean create(T t);
    boolean delete(int id);
    T findById(int id);
     List<T> getAll();
}
