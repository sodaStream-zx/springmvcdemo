package com.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author 一杯咖啡
 */
public class WebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * desc: spring IOC容器
     *
     * @Return:
     **/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * desc: dispatcherServlet uri 映射配置
     *
     * @Return:
     **/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * desc: dispatcher 拦截请求匹配
     *
     * @Return:
     **/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
