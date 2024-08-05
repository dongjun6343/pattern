package org.study.pattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplateGeneric<T> {

    // 변하지 않는 부분
    public T execute() {
        long startTime = System.currentTimeMillis();

        // 로직 호출
        T result = call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

        return result;
    }

    // 변하는 부분
    protected abstract T call();
}
