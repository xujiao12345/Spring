package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//声明是一个控制器
public class HelloController {
    @RequestMapping("/index")//配置url和方法之间的映射
    public String hello(){
        System.out.println("111");
        return "index";//页面的放置路径为/web-inf/classes/views/index.jsp
    }
}
