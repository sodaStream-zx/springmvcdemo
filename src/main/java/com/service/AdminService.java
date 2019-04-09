package com.service;

import com.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements BaseService<Admin> {

    @Override
    public boolean add(Admin o) {
        return false;
    }

    @Override
    public boolean fresh(Admin o) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Admin findOne(Integer id) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }
}
