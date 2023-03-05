package learnspring.advanced.trace.hellotrace;

import learnspring.advanced.trace.TraceId;
import learnspring.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}",traceId.getId());
        return new TraceStatus(traceId,startTimeMs,message);
    }
    public void end(TraceStatus status){
        complete(status,null);
    }
    public void exception(TraceStatus status, Exception e){
        complete(status,e);
    }

    private void complete(TraceStatus status, Exception e) {

    }
}
