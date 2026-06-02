package com.phoniex.spring.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.lang.runtime.ObjectMethods;

public class JsonTest {

    @Test
    void testObject2Json() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //创建一个java对象
        UserInfo userInfo = new UserInfo();
        userInfo.setName("zhangsan");
        userInfo.setAge(15);
        userInfo.setGender(1);
        //对象转json
        String string = objectMapper.writeValueAsString(userInfo);
        System.out.println(string);
    }
    @Test
    void testJson2Object() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //定义一个json字符串
        String s = "{\"name\":\"zhangsan\",\"gender\":1,\"age\":15}";
        //json 转对象
        UserInfo userInfo = objectMapper.readValue(s,UserInfo.class);
        System.out.println(userInfo);
    }



}
