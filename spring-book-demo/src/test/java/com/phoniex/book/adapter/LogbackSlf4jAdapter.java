package com.phoniex.book.adapter;

public class LogbackSlf4jAdapter implements Slf4jApi {
    Logback logback = new Logback();
    @Override
    public void log(String log) {
        logback.print(log);
    }
}
