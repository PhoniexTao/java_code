package com.phoniex.ioc.component;

import com.phoniex.ioc.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {
    @Primary
    @Bean({"s3","s4"})   //起双名
    public Student s1(){
        return new Student("zhangsan",11);

    }

    @Bean
    private  String name(){
        return "lisi";
    }
    @Bean
    public Student s2(String name){
        return new Student(name,18);
    }

    @Bean Student s5(Student s3){
        return new Student(s3.getName(),18);
    }

}
