package com.phoniex.ioc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Component
public class Student {

    private String name;
    private Integer age;
}
