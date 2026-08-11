package com.phoniex.book.adapter;

public class Log4jSlf4jAdapter implements Slf4jApi {

    private Log4j log4j;
    @Override
    public void log(String log) {
        log4j.log(log);
    }
}
