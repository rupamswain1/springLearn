package in.rupam.Spring.Ecomm.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* in.rupam.Spring.Ecomm.service.ProductService.getProductsByKeyWord(..)) && args(keyword)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, String keyword) throws Throwable {
        LOGGER.info("Searched by "+keyword);
        keyword = keyword.trim();
        LOGGER.info("Search param processed to "+keyword);
        Object obj = jp.proceed(new Object[]{keyword});
        return obj;
    }
}
