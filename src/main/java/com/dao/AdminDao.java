package com.dao;

import com.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 一杯咖啡
 */
@Repository
public class AdminDao implements Crud<Admin> {
    @Override
    public Integer add(Admin o) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer fresh(Admin o) {
        return null;
    }

    @Override
    public Admin findOne(Integer id) {
        return null;
    }
}
