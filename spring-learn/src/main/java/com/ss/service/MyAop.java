package com.ss.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author fangsheng
 * @date 2021/5/21 2:36 下午
 */
@Slf4j
@Aspect
@Component
public class MyAop {

    @Pointcut("execution(public int com.ss.aop.aopservice.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before1(JoinPoint joinPoint) {
        Map params = AopHelper.getMethodParams(joinPoint);
        params.forEach((key, val) -> {
            if (Objects.isNull(val)) {
                throw new RuntimeException("参数" + key + "不能为空");
            }
        });
        log.info("【测试前置增强：】" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
    }
}
