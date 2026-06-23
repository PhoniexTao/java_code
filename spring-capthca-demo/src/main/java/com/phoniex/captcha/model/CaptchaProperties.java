package com.phoniex.captcha.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "captcha")
@Configuration
@Data
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session;

    @Data
    public static class Session{
        private String key;
        private String date;
    }
}
