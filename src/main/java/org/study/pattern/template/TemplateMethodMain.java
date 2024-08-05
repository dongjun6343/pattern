package org.study.pattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodMain {

    public static void main(String[] args) {
//        logic1();
//        logic2();
//        templateMethodV1();
        templateMethodV2();
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
     *
     * 다형성을 사용해서 변하는 부분과 변하지 않는 부분을 분리하는 방법.
     *
     * 하지만, 템플릿 메서드 패턴은 SubClassLogic1 , SubClassLogic2를 계속 만들어야 하는 단점이 있다
     * => 어떻게 해결할까? => 익명 내부 클래스 사용해보자!
     */
    private static void templateMethodV1() {
        AbstractTemplate template = new SubClassLogic1();
        template.execute();

        AbstractTemplate template1 = new SubClassLogic2();
        template1.execute();
    }


    /**
     * 익명 내부 클래스 => 변경
     */
    private static void templateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };
        template.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };
        template2.execute();
    }

}
