package org.study.pattern.strategy.templatecallback;

/**
 * Context -> Template
 * Strategy -> Callback
 */

public class CallBackMain {
    public static void main(String[] args) {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> System.out.println("비즈니스 로직 실행"));
    }
}
