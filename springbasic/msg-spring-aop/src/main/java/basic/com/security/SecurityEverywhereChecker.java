package basic.com.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityEverywhereChecker{
    private static final Logger logger = LoggerFactory.getLogger(SecurityEverywhereChecker.class);

    @Pointcut("execution(* basic.com..*.*(..))")
    public void everyMessageMethod() {}

    @Around("everyMessageMethod()")
    public Object checkSecurity (ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("*** AOP, everywhere checker >>>>>>");
        // Implement security check logics here
        Object result = joinPoint.proceed();
        logger.info("*** AOP, everywhere checker <<<<<<");
        return result;
    }


}