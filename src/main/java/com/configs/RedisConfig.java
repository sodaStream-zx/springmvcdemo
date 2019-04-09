package com.configs;

import com.dataSource.DataSource;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-26-23:36
 */
public class RedisConfig {
    private static final Logger log = Logger.getLogger(RedisConfig.class);

    private static Properties pro;

    static {
        try {
            InputStream in = DataSource.class.getClassLoader().getResourceAsStream("redis.properties");
            pro = new Properties();
            pro.load(in);
        } catch (IOException e) {
            log.error("io 异常");
        }
    }

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("redis.properties");
        try {
            InputStream in = resource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                if (content.startsWith("#")) {
                    continue;
                } else {
                    System.out.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(pro.toString());
    }
}
