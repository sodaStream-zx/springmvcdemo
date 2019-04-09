package com.dao;


import java.util.List;

public interface Crud<T> {
    Integer add(T o);

    List<T> findAll();

    Integer delete(Integer id);

    Integer fresh(T o);

    T findOne(Integer id);
}
