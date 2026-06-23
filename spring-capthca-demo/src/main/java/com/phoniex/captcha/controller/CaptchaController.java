package com.phoniex.captcha.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.phoniex.captcha.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaProperties captchaProperties;
    private final static Long VALID_TIME = 30 * 60 * 1000L ;

    @RequestMapping("/getCaptcha")
    public void getCaptcTha(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        //一般情况下，这个处理时前端做的,用来禁止浏览器缓存代码
//        response.setHeader("Progma","No-cache");
//        response.setCharacterEncoding("utf-8");
        //生成验证码
        try {
            LineCaptcha captcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
            String code = captcha.getCode();
            session.setAttribute(captchaProperties.getSession().getKey(), code);
            session.setAttribute(captchaProperties.getSession().getDate(), new Date());
            captcha.write(response.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.getOutputStream().close();
        }
    }

    //验证用户输入的验证码是否正确
    @RequestMapping("/check")
    public boolean check(String captcha,HttpSession session){
        if(!StringUtils.hasLength(captcha)){
            return false;
        }
        //验证 验证码
        String code = (String) session.getAttribute(captchaProperties.getSession().getKey());
        Date date = (Date) session.getAttribute(captchaProperties.getSession().getDate());
        if(captcha.equalsIgnoreCase(code) && date != null && System.currentTimeMillis() - date.getTime() < VALID_TIME){
            return true;
        }
        return false;
    }
}
