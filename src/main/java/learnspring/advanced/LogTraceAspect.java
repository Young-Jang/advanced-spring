package learnspring.advanced;

import learnspring.advanced.trace.TraceStatus;
import learnspring.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class LogTraceAspect  {
    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace){
        this.logTrace = logTrace;
    }

    @Around("execution(* learnspring.advanced.learnJPA..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        TraceStatus traceStatus = null;
        try{
            String message = joinPoint.getSignature().toLongString();
            traceStatus = logTrace.begin(message);
            Object result = joinPoint.proceed();
            logTrace.end(traceStatus);
            return result;
        }catch (Exception e){
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
