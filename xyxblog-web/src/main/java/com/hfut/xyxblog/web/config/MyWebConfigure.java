package com.hfut.xyxblog.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MyWebConfigure implements WebMvcConfigurer {

    //在配置文件中配置的文件保存路径
    @Value("${myFiles.imagePath}")
    private String imageRealPath;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize(DataSize.parse("1024MB"));
        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("1024MB"));
        return factory.createMultipartConfig();
    }

    //前端访问静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imageRootPath = System.getProperty("user.dir") + imageRealPath;
        registry.addResourceHandler("/files/images/**").addResourceLocations("file:" + imageRootPath);
    }
}
