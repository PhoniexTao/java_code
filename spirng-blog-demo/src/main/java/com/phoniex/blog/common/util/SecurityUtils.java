package com.phoniex.blog.common.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SecurityUtils {
    public static String encrypt(String password){
        String salt = UUID.randomUUID().toString().replace("-","");
        String securityPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
        return salt + securityPassword;
    }
    public static boolean verify(String inputPassword,String sqlPassword){
        if(!StringUtils.hasLength(inputPassword)){
            return false;
        }
        if(sqlPassword == null || sqlPassword.length() != 64){
            return false;
        }
        //由数据库存储的密码截取前32位得出盐值
        String salt = sqlPassword.substring(0, 32);

        //使用同样的过程算法来与结果判断：
        String securityPassword = DigestUtils.md5DigestAsHex((salt + inputPassword).getBytes(StandardCharsets.UTF_8));
        return sqlPassword.equals(salt + securityPassword);
    }
}
