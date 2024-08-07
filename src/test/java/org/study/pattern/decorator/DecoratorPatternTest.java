package org.study.pattern.decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    @DisplayName("데코레이터 패턴 적용 전")
    void noDecoratorTest() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }


    @Test
    @DisplayName("데코레이터 패턴 적용 후 - 클래스 의존 관계")
    void decoratorTest() {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator); // 클라이언트쪽 수정없이 새로운 기능 추가가 목적
        client.execute();
    }

    // 프록시는 체인이 가능하다.
    // 기존 데코레이터에 더해서 실행 시간을 측정하는 기능을 추가해보자.

    @Test
    @DisplayName("데코레이터 패턴 적용 후 - 기존 데코레이터에 더해서 실행 시간을 측정하는 기능")
    void decoratorTest2() {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator); // 클라이언트쪽 수정없이 새로운 기능 추가가 목적
        client.execute();
    }
}
