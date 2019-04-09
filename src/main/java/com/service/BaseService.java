package com.service;


import java.util.List;

/**
 * @author 一杯咖啡
 */
public interface BaseService<T> {
    boolean add(T o);

    boolean fresh(T o);

    boolean delete(Integer id);

    T findOne(Integer id);

    List<T> findAll();
}
