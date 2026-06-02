package com.phoniex.spring.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @RequestMapping("r1")
    public String r1(String keyword) {
        return "接收参数: " + keyword;
    }

    @RequestMapping("r2")
    public String r2(String userName, String password) {
        return "接收参数: userName: " + userName + " pas sword: " + password;
    }

    @RequestMapping("/r5")
    public String r5(UserInfo userInfo) {
        return "接收参数 : userInfo = " + userInfo.toString();
    }

    //接收前端参数名为为q的代码，如果接收不到则报错
    @RequestMapping("/r6")
    public String r6(@RequestParam("q") String keyword) {
        return "接收参数: keyword = " + keyword;
    }

    ////接收前端参数名为为q的代码，如果接收不到返回null不报错
    @RequestMapping("/r7")
    public String r7(@RequestParam(value = "q", required = false) String keyword) {
        return "接收参数 ： keyword= " + keyword;
    }

    //传递数组
    @RequestMapping("/r8")
    public String r8(String[] arr) {
        return "接收参数: arr = " + arr;
    }

    //传递集合 ： 要进行参数绑定
    @RequestMapping("/r9")
    public String r9(@RequestParam List<Integer> list) {
        return "接收参数 ： list = " + list;
    }

    @RequestMapping("/r10")
    public String r10(@RequestBody UserInfo userInfo) {
        return userInfo.toString();
    }

    //从url中获取参数
    @RequestMapping("/article/{articleId}")    //{}包括的是一个变量，检测到格式一样直接捕获到
    public String r10(@PathVariable Integer articleId) {    //@PathVariable注解会直接让捕获的变量传给这个参数
        return "获取文章Id：" + articleId;
    }

    @RequestMapping("/article/{type}/{articleId}")
    public String r11(@PathVariable Integer articleId, @PathVariable String type) {
        return "获取文章ID" + articleId + ", type : " + type;
    }

    //上传文件
    @RequestMapping("/r12")
    public String R12(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        //文件上传
        file.transferTo(new File("E:/tmp/" + file.getOriginalFilename()));
        return "文件上传成功";
    }
}
