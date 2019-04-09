package com.service;

import com.dao.Crud;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 一杯咖啡
 */
@Service
public class StudentService implements BaseService<Student> {
    @Autowired
    private Crud studentDao;

    @Override
    public boolean add(Student o) {
        Integer flag = studentDao.add(o);
        return flag != 0;
    }

    @Override
    public boolean fresh(Student o) {
        int flag = studentDao.fresh(o);
        return flag != 0;
    }

    @Override
    public boolean delete(Integer id) {
        Integer flag = studentDao.delete(id);
        return flag != 0;
    }

    @Override
    public Student findOne(Integer id) {
        Student student = (Student) studentDao.findOne(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
