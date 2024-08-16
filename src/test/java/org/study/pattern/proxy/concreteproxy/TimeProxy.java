package org.study.pattern.proxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        // 로직
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();

        String operation = concreteLogic.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("TimeDecorator 종료 resultTime = {}", resultTime);

        return operation;
    }
}
