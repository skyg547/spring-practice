package study.cli.AOp;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class AopBean {
    public void log() {

        log.error("aop log");
    }

    public void aroundLog(ProceedingJoinPoint pjp) {
        log.error(">>>berfore aop log");
        try {
            Object proceed = pjp.proceed();
            log.error("returninng aop log");
        } catch (Throwable throwable) {

            log.error(">> throwing aop log");
        }
        log.error("afoter aop log ");
    }

}

