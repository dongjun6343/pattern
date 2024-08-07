package org.study.pattern.proxy;


public class ProxyMain {
    public static void main(String[] args) {
        /**
         * 클라이언트 -   서버
         * (요청자)    (처리자)
         *
         * 클라이언트 -> 서버  : 직접호출
         * 클라이언트 -> 프록시 -> 서버 : 간접호출
         *
         * 프록시 - 대리자
         *
         * 프록시가 있으면 접근제어, 부가 기능 추가를 수행할 수 있다.
         * 프록시 패턴 : 접근 제어가 목적
         * 데코레이터 패턴 : 새로운 기능 추가가 목적
         *  => 둘 다 프록시를 사용하는 방법이지만, 의도에 따라서 패턴을 구분한다.
         *
         */
    }
}
