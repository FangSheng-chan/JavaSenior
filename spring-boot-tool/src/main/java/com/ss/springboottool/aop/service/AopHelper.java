package com.ss.springboottool.aop.service;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/5/21 2:31 下午
 */
@Slf4j
public class AopHelper {
    public static Map getMethodParams(JoinPoint joinPoint) {
        /**
         * 获取到参数名称
         */
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        log.info("names = " + Arrays.toString(names));
        Map params = new HashMap();
        for (String name : names) {
            if (name.isEmpty()) {
                return params;
            }
        }
        /**
         * 获取到参数数值
         */
        Object[] values = joinPoint.getArgs();
        log.info("joinPoint.getArgs == " + Arrays.toString(values));

        /**
         * put 参数名称对应的参数值
         */
        for (int i = 0; i < names.length; i++) {
            params.put(names[i], values[i]);
        }
        log.info("params = " + params);
        return params;
    }

    public static boolean isAdmin(JoinPoint joinPoint){
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();
        Map params = new HashMap();
        for (int i = 0; i < names.length; i++) {
            params.put(names[i], args[i]);
        }
        if (params.get("userName").equals("ss")){
            return true;
        }else {
            return false;
        }
    }
}