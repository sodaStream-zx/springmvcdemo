package com.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 一杯咖啡
 */
@Configuration
@ComponentScan(value = "com.*",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
@EnableWebMvc
public class WebConfig {

    /**
     * desc:视图解析器
     *
     * @Return:
     **/
    @Bean(name = "internalResourceViewResolver")
    public ViewResolver initResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * desc: 初始化RequestMapingHanderAdapter ,并加载Http 的json转化器
     **/
    @Bean(name = "requestMappingHandlerAdapter")
    public HandlerAdapter initRequestHnadler() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(mediaType);
        converter.setSupportedMediaTypes(mediaTypes);
        adapter.getMessageConverters().add(converter);
        return adapter;
    }
}
