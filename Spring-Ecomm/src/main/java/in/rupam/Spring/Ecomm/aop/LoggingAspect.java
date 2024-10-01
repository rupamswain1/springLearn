package in.rupam.Spring.Ecomm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* in.rupam.Spring.Ecomm.service.ProductService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }

    @After("execution(* in.rupam.Spring.Ecomm.service.ProductService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* in.rupam.Spring.Ecomm.service.ProductService.*(..))")
    public void logMethodFailed(JoinPoint jp){
        LOGGER.info("Method Throwing "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* in.rupam.Spring.Ecomm.service.ProductService.*(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }
}
