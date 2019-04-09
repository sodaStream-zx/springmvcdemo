package com.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 一杯咖啡
 */
public class StudentControllerTest {
    private static final Logger log = Logger.getLogger(StudentControllerTest.class);

    /**
     * 数据库测试
     */
    @Test
    public void list() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        DataSource ds = (DataSource) ac.getBean("dataSource");
        //WebMvcConfigurer webMvcConfigurer = (WebMvcConfigurer) ac.getBean("mvcConfig");
        // System.out.println(webMvcConfigurer.toString());
        log.info(ds.getConnection().getMetaData().allTablesAreSelectable());
        Assert.isTrue(!ds.getConnection().getMetaData().allTablesAreSelectable());
    }
}