package com.phoniex.spring.demo.controller;


import com.phoniex.spring.demo.model.UserInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/resp")
//如果想返回页面，用Controller注解
//如果想返回数据，用 RequestController 或者 Controller + ResponseBody
@Controller
public class ResponController {
    @RequestMapping("/r1")
    public String returnPage(){
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/r2")
    public String returnData(){
        return "我是前端需要的数据";
    }

    @ResponseBody
    @RequestMapping("/r3")
    public String returnHtml(){
        return "<h1>我是Index页面</h1>";
    }
    //如果想要改变返回的内容解析类型:
    @ResponseBody
    @RequestMapping(value = "/r4",produces = "text/plain")
    public String returnText(){
        return "<h1>我是Index页面</h1>";
    }
    //返回json类型
    @ResponseBody
    @RequestMapping(value = "/r5")
    //返回类型为类，响应的内容类型自动转为json
    public UserInfo returnJson(){
        UserInfo userInfo = new UserInfo("zhangsan",1,1);
        return userInfo;

    }
    @ResponseBody
    @RequestMapping(value = "/r6")
    public UserInfo setStatus(HttpServletResponse response){
        response.setStatus(401);
        UserInfo userInfo = new UserInfo("zhangsan",1,1);
        return userInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/r7")
    public String setHeader(HttpServletResponse response){
        response.setHeader("myHeader","myHeader");
        return "设置Header成功";
    }
}
