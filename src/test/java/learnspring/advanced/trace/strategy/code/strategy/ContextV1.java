package learnspring.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();

        log.info("비즈니스1 로직 실행");
        strategy.call();
        long endTime = System.currentTimeMillis();
        log.info("resultTime={}",endTime-startTime);
    }
}
