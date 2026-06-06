package com.phoniex.spring.demo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
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

    @RequestMapping("/r13")
    public String r13(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        return "返回Cookie成功";
    }

    //注解方式获得Cookie
    @RequestMapping("/r14")
    public String r14(@CookieValue("java") String java){
        return "从Cookie中获取Java的值：" + java;
    }

    //session的存储
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        //从Cookie中获取sessionId，根据sessionId 获取session对象
        HttpSession session = request.getSession(true);
        //这里默认为true ，是true时，如果没有获取到session 返回一个空的Session对象，
        //              时false时，如果没有获取到session，返回null
        //这里是存储session，所以直接返回空对象即可
        session.setAttribute("userName", "zhangsan");
        session.setAttribute("age", 17);
        return "设置session成功";

    }
    //获取session
    @RequestMapping("/getSession")
    public String getSeesion(HttpServletRequest request){
        //从cookie中获取sessionId，根据sessionId，获取Session元素
        HttpSession session = request.getSession(false);
        if(session == null){
            return "用户未登录";
        }else{
             //从session中获取登录用户的信息
            String userName = (String) session.getAttribute("userName");
            return "登录用户为：";
        }
    }
    @RequestMapping("/getSession2")
    public String getSeesion(HttpSession session){
            String userName = (String) session.getAttribute("userName");
            return "登录用户为：";
    }
    @RequestMapping("/getSession3")
    public String getSeesion(@SessionAttribute("userName") String userName){
        return "登录用户为：";
    }

    //获取header
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "从heardr中获取userAgent" + userAgent;
    }
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent")String userAgent){
        return "从heardr中获取userAgent" + userAgent;
    }


}
