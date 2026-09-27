package com.livein.springbootrest.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidInput {
    public static Logger log= LoggerFactory.getLogger(ValidInput.class);

    @Around("execution(* com.livein.springbootrest.service.JobService.getJob(. .)) && args(postid)")
    public Object validate(ProceedingJoinPoint jp,int postid) throws Throwable {

        if(postid<0) {
            log.info("postid is negative");
            postid = -postid;
            log.info("postid is "+postid);
        }
        Object obj=jp.proceed(new Object[]{postid});
        return obj;

    }
}
