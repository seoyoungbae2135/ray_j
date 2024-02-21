package com.example.jpatest.config;
//20240220-8
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**") // static폴더에 있는 image와 이름을 다르게 설정
                .addResourceLocations("file:///C:/ray/"); // application.properties에 저장된 경로
    }
}
