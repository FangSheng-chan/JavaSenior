package com.ss.springboottool.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Pointcut()
    public void pointCut() {

    }

    @Before(value = "execution(public * com.ss.springboottool.aop.service.*.*(..))")
    public void before1(JoinPoint joinPoint) {
        Map params = AopHelper.getMethodParams(joinPoint);

        params.forEach((key, val) -> {
            System.out.println(key + "" + "\t" + val);
        });

        params.forEach((key, val) -> {
            if (Objects.isNull(val)) {
                throw new RuntimeException("参数" + key + "不能为空");
            }
        });
        log.info("【测试前置增强：】" + joinPoint.getTarget().getClass().getName() + ",\t" + joinPoint.getSignature().getName());
    }

    @After(value = "target(com.ss.springboottool.aop.service.CustomerService)")
    public void after1(JoinPoint joinPoint) {
        boolean success = AopHelper.isAdmin(joinPoint);
        if (success) {
            log.info("后置增强AfterAop测试指定目标匹配 " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "管理员");
        } else {
            log.info("后置增强AfterAop测试指定目标匹配 " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "普通用户");
        }
    }

    @Around("@annotation(com.ss.springboottool.aop.service.RunTimeLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("【进入环绕增强】触发环绕那个增强开始");
        long startTime = System.currentTimeMillis();
        Object result = null;
        result = proceedingJoinPoint.proceed();
        log.info("【测试环绕增强：】当前方法{}执行成功,调用者为：{}，  此方法运行时间为:{} ms", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getTarget().getClass().getName(), (System.currentTimeMillis() - startTime));
        return result;
    }

}
