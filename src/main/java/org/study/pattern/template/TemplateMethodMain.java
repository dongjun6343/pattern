package org.study.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 진정한 좋은 설계는 뭘까?
 * 변경이 일어날때 자연스럽게 드러난다.
 *
 *
 * 단일 책임 원칙 (SRP)
 * 로그를 남기는 부분에 단일 책임 원칙을 지켰다.
 *  => 변경 지점을 하나로 모아서 변경에 쉽게 대처할 수 있는 구조를 만든 것이다.
 *
 * 템플릿 메서드 패턴은 상속 구조를 사용하고 있어서 익명클래스나 익명 내부 클래스를 만들어야 하고,
 * 자식 클래스 입장에서는 부모 클래스의 기능을 전혀 사용하지 않지만, 부모 클래스를 알아야한다(상속)
 *
 * 이러한 단점을 제거하기 위해 템플릿 메서드 패턴과 비슷한 역할을 하는 디자인 패턴이 전략 패턴이다.
 */


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
