package org.study.pattern.proxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

    public String operation() {
        log.info("ConcreteLogic opertaion 실행");
        return "data";
    }
}
