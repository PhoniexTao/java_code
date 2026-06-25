package com.phoniex.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {
//    private final static Logger logger = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/print")
    public String print() {
        System.out.println("sout打印日志");
        log.info("logger 打印日志");
        log.trace("logger trace");
        log.debug("logger debug");
        log.info("logger info");
        log.warn("logger warn");
        log .error("logger error");

        return "打印日志";
    }
}
