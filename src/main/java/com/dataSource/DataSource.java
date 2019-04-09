package com.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 一杯咖啡
 */
@Configuration
public class DataSource {
    /**
     * desc:读取配置文件
     *
     * @Return:
     **/
    private static Properties pro;

    static {
        try {
            InputStream in = DataSource.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro = new Properties();
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * desc: 配置dbcp数据源
     *
     * @Return: BasicDataSource对象
     **/
    @Bean(name = "druidDataSource")
    public DruidDataSource initDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(pro.getProperty("dbcp.driverClassName"));
        dataSource.setUrl(pro.getProperty("dbcp.url"));
        dataSource.setUsername(pro.getProperty("dbcp.username"));
        dataSource.setPassword(pro.getProperty("dbcp.password"));
        return dataSource;
    }

    /**
     * desc:配置JdbcTemplate
     *
     * @Return: jdbctemplate 对象
     **/
    @Bean(name = "jdbcTemplate")
    @Autowired
    @DependsOn(value = "druidDataSource")
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource) {
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        return jt;
    }
}
