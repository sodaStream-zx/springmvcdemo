package com.dao;

import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 一杯咖啡
 */
@Repository
public class StudentDao implements Crud<Student> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer add(Student o) {
        String sql = "insert into student(s_name,s_age) values(?,?)";
        Object[] param = new Object[]{o.getSname(), o.getSage()};
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public List<Student> findAll() {
        String sql = "Select * from student";
        List<Student> list = new ArrayList<>();
        jdbcTemplate.query(sql, resultSet -> {
            Student student = new Student();
            student.setSid(resultSet.getInt(1));
            student.setSname(resultSet.getString(2));
            student.setSage(resultSet.getInt(3));
            list.add(student);
        });
        return list;
    }

    @Override
    public Integer delete(Integer id) {
        String sql = "DELETE FROM student WHERE s_id = " + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public Integer fresh(Student o) {
        String sql = "UPDATE student set s_name = '" + o.getSname() + "',s_age = " + o.getSage() + " WHERE s_id = " + o.getSid();
        return jdbcTemplate.update(sql);
    }

    @Override
    public Student findOne(Integer id) {
        String sql = "SELECT * FROM student where s_id = " + id;
        List<Student> student = jdbcTemplate.query(sql, (resultSet, i) -> {
            Student student1 = new Student();
            student1.setSname(resultSet.getString(2));
            student1.setSage(resultSet.getInt(3));
            return student1;
        });
        return student.get(0);
    }
}
