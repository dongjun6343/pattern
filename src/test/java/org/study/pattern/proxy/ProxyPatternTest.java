package org.study.pattern.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    @DisplayName("프록시 패턴 적용 x")
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }


    @Test
    @DisplayName("프록시 패턴 사용 - 캐시 적용 (프록시 패턴 : 접근 제어가 목적)")
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject); // 프록시 추가
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();

        /**
         * 16:43:19.477 [Test worker] INFO org.study.pattern.proxy.CacheProxy -- 프록시 호출
         * 16:43:19.489 [Test worker] INFO org.study.pattern.proxy.RealSubject -- 실제 객체 호출
         * 16:43:20.498 [Test worker] INFO org.study.pattern.proxy.CacheProxy -- 프록시 호출
         * 16:43:20.501 [Test worker] INFO org.study.pattern.proxy.CacheProxy -- 프록시 호출
         */
    }
}
