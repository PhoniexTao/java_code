package com.phoniex.ioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "person")
@Configuration
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
}
