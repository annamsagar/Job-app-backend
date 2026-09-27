package com.livein.springbootrest.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {



    private static Logger log= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.livein.springbootrest.service.*.getJob(. .)))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();

        Object obj = jp.proceed();
        long end=System.currentTimeMillis();
        log.info("[PerformanceMonitorAspect] "+(end-start)+"ms");
        return obj;
    }
}
