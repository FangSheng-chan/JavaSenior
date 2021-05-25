package com.ss.service;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/5/21 2:31 下午
 */
@Slf4j
public class AopHelper {
    public static Map getMethodParams(JoinPoint joinPoint) {
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Map params = new HashMap();
        for (String name : names) {
            if (name.isEmpty()) {
                return params;
            }
        }
        Object[] values = joinPoint.getArgs();
        log.info("joinPoint.getArgs == " + values);
        for (int i = 0; i < names.length; i++) {
            params.put(names[i], values[i]);
        }
        log.info("params = " + params);
        return params;
    }
}