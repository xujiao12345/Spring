package com.wisely.highlight_springmvc4.messageconverter;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {//继承此接口来实现自定义的HttpMessageConverter
    public MyMessageConverter(){
        super(new MediaType("application","x-wisely",Charset.forName("UTF-8")));//新建一个自定义的媒体类型为application/x-wisely
    }

    @Override
    protected boolean supports(Class<?> aClass) {//表明httpMessageConverter只处理DemoObj这个类
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp=StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        System.out.println("temp============"+temp);
        String[] tempAttr=temp.split("-");
        return new DemoObj(new Long(tempAttr[0]),tempAttr[1]);
    }//处理请求的数据

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+obj.getId()+"-"+obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }//处理数据如何输出到response中
}
