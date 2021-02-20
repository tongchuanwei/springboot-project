package com.hello.way.project.web.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * @author   way
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /** boot上传配置 */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置单个文件大小限制 ,超出设置页面会抛出异常信息，
        factory.setMaxFileSize("5MB");
        /// 设置一次请求上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

}
