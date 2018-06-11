package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//声明一个控制器建言，组合@component注解，所以自动注册为Spring的bean
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)//全局控制器中的所有exception异常
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute//添加model attribute到全局，所有注解的@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder//绑定页面请求参数
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");//忽略页面的id请求的参数
    }
}
