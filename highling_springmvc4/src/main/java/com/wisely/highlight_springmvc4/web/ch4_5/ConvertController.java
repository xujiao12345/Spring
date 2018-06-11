package com.wisely.highlight_springmvc4.web.ch4_5;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConvertController {
    @RequestMapping(value = "convert",produces = {"application/x-wisely"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj obj){
        return  obj;
    }
}
