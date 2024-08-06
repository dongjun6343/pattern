package org.study.pattern.strategy.code.strategy;

public class StrategyLogic2 implements Strategy {
    @Override
    public void call() {
        System.out.println("비즈니스 로직 2");
    }
}
