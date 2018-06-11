package com.wisely.highlight_springmvc4.web.ch4_3;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller//此类是一个控制器
@RequestMapping("/anno")//累的访问路径为/anno
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8")//produce定制返回的response的媒体类型和字符集
    public @ResponseBody String index(HttpServletRequest request){//@ResponseBody用在返回值前面
        return "url:"+request.getRequestURL()+" can access";
    }

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){//@PathVariable 接收请求路径参数
        return "url:"+request.getRequestURL()+" can access,str: "+str;
    }//http://localhost:8090//highling_springmvc4/anno/pathvar/xx

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+ request.getRequestURL()+" can accsess,id:"+id;
    }//常规的request参数获取.http://localhost:8090//highling_springmvc4/anno/requestParam?id=1

    @RequestMapping(value="/obj",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,obj.getid: "+obj.getId()+" obj.getName:"+obj.getName();
    }//解释参数到对象http://localhost:8090//highling_springmvc4/anno/obj?id=1&name=xx

    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }//不同的路径到同一个方法


}
