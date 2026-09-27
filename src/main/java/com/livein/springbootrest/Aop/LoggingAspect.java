package com.livein.springbootrest.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static Logger log= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.livein.springbootrest.service.JobService.getJob(. .)) || execution(* com.livein.springbootrest.service.JobService.updateJob(. .)) ")
    public void logmethodcall(JoinPoint jp)
    {

        log.info("method call"+jp.getSignature().getName());
    }

    @After("execution(* com.livein.springbootrest.service.JobService.getJob(. .))")
    public void logmethodexecuted(JoinPoint jp)
    {

        log.info("method Executed"+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.livein.springbootrest.service.JobService.getJob(. .))")
    public void logmethoderror(JoinPoint jp)
    {

        log.info("method has error"+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.livein.springbootrest.service.JobService.getJob(. .))")
    public void logmethodreturned(JoinPoint jp)
    {

        log.info("method returned success"+jp.getSignature().getName());
    }
}
