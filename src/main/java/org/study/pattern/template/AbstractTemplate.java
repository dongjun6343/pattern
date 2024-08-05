package org.study.pattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    // 변하지 않는 부분
    public void execute() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        //log.info("비즈니스 로직1 실행");
        call(); // 상속
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    // 변하는 부분
    protected abstract void call();

    /**
     * 부모 클래스에 변하지 않는 템플릿 코드를 두고,
     * 변하는 부분은 자식 클래스에 두고 상속과 오버라이딩을 사용해서 처리한다.
     */
}
