package learnspring.advanced.trace.template;

import learnspring.advanced.trace.template.code.AbstractTemplate;
import learnspring.advanced.trace.template.code.SubClassLogic1;
import learnspring.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TemplateMethodTest {
    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

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
    void templateMethodV1(){
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2(){
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        template2.execute();
    }
}
