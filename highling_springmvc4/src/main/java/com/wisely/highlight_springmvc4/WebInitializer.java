package com.wisely.highlight_springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
//web配置
public class WebInitializer implements WebApplicationInitializer {
    //webapplicationInitializer是Spring 提供用来配置Servlet3.0+配置的接口，从而实现替代web.xml的位置，实现此接口将会自动被SpringServletContainerInitializer（用来启动servlet3.0容器）获取到
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();//新建WebapplicationContext,注册配置类，并将其和当前servletContext关联
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));//注册springMVC的DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
