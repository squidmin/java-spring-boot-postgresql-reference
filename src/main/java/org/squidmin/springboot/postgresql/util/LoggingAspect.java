package org.squidmin.springboot.postgresql.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* org.squidmin.springboot.postgresql.service.*.*(..))")
    public void logBeforeServiceMethods() {
        log.info("Calling service layer");
    }

}
