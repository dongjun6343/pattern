package org.study.pattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodMain {

    public static void main(String[] args) {
//        logic1();
//        logic2();
        templateMethod();
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

    /**
     * 템플릿 메서드 패턴 사용
     * 상속 + 오버라이딩
     */
    private static void templateMethod() {
        AbstractTemplate template = new SubClassLogic1();
        template.execute();

        AbstractTemplate template1 = new SubClassLogic2();
        template1.execute();
    }
}
