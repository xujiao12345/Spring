package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc//开启一些默认配置，如一些viewResolver或者MessageConverter等,若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig  extends WebMvcConfigurerAdapter {//继承该类，重写其方法客队SpringMVC进行配置

    //配置了一个jsp的ViewResolver,用来映射路径和实际页面的位置
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");//看到的页面效果是运行时而不是开发时的代码，运行时代码会将我们的页面自动编译到/web-inf/classes/views下
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        System.out.println("Servlet启动");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        //addResourceLocations指的是文件放置的目录，addResourceHandlers指的是对外暴露的访问路径
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    //添加转向upload页面的ViewController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
    }

    //MultipartResolver配置
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(1000000);
        return multipartResolver;
    }

    //在springmvc中注册httpMessageConverter

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }
}