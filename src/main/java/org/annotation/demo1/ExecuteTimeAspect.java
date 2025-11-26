package org.annotation.demo1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ExecuteTimeAspect {

    @Around("@annotation(org.annotation.demo1.ExecuteTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        // 执行目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long executionTime = end - start;

        // 获取方法信息
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ExecuteTime executionTimeAnnotation = method.getAnnotation(ExecuteTime.class);
        String methodDescription = executionTimeAnnotation.value();

        // 记录方法执行时间
        log.info("MethodName = {}, MethodDescription = {}, execution time = {}ms", method.getName(), methodDescription, executionTime);
        return result;
    }
}
