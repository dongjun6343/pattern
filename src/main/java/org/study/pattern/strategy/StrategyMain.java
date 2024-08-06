package org.study.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.study.pattern.strategy.code.strategy.*;

/**
 * 전략 패턴
 * 변하지 않는 부분을 Context
 * 변하는 부분 Stragegy 라는 인터페이스를 만들고 인터페이스를 구현 ( 상속이 아니라 위임을 한다.)
 */

@Slf4j
public class StrategyMain {
    public static void main(String[] args) {
//        logic1();
//        logic2();
//        strategyV1();
//        strategyV2();
        strategyContextV2();
    }


    private static void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private static void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
    
    private static void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        // strategyLogic1 주입
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    private static void strategyV2() {
        ContextV1 context1 = new ContextV1(() -> System.out.println("비즈니스 로직1 실행"));
        context1.execute();
        ContextV1 context2 = new ContextV1(() -> System.out.println("비즈니스 로직2 실행"));
        context2.execute();
    }

    private static void strategyContextV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }
}
