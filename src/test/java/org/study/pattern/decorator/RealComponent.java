package org.study.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {

    @Override
    public String operation() {
        log.info("RealComponent operation 실행" );
        return "data";
    }
}
