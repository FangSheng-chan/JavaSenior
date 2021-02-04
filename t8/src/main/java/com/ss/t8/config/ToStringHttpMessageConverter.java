package com.ss.t8.config;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author fangsheng
 * @date 2021/1/26 11:21 上午
 */
public class ToStringHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public ToStringHttpMessageConverter() {
        super(new MediaType("application", "toString", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }

    //从请求体封装数据 对应RequestBody 用String接收
    @Override
    protected Object readInternal(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
    }

    //从响应体封装数据 对应ResponseBody
    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String result = o.toString();
        httpOutputMessage.getBody().write(result.getBytes());
    }
}
