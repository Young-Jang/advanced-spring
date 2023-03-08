package learnspring.advanced.trace.strategy;

import learnspring.advanced.trace.strategy.code.strategy.ContextV1;
import learnspring.advanced.trace.strategy.code.strategy.StrategyLogic1;
import learnspring.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {


    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스1 로직 실행");

        long endTime = System.currentTimeMillis();
        log.info("resultTime={}",endTime-startTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스2 로직 실행");

        long endTime = System.currentTimeMillis();
        log.info("resultTime={}",endTime-startTime);
    }



    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }


}
