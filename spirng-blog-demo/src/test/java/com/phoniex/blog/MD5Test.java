package com.phoniex.blog;

import com.phoniex.blog.common.util.SecurityUtils;
import org.apache.ibatis.ognl.ASTGreater;
import org.junit.jupiter.api.Test;

public class MD5Test {
    @Test
    void test(){
        String encrypt = SecurityUtils.encrypt("123456");
        System.out.println(encrypt);
        boolean verfiy = SecurityUtils.verify("123456",encrypt);
        System.out.println(verfiy);
    }
}
