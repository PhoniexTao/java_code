package com.phoniex.blog;

import com.phoniex.blog.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class
JwtTest {
    @Test
    void gotToken(){
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Key key = Keys.hmacShaKeyFor("y97aRNf5CW0E26aMrISKWHnvwjQCvrm9sMlPjMrrrYI=".getBytes(StandardCharsets.UTF_8));
        Map<String ,Object> claims = new HashMap<>();
       claims.put("id",12);
       claims.put("name","zhangsan");

       String compact = Jwts.builder()
           .setClaims(claims)
           .signWith(key)
           .compact();
        System.out.println(compact);
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        System.out.println(build.parse(compact).getBody());
    }
    @Test
    void getKey(){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(encode);
    }
    @Test
    void getToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6MX0.CgR8rXL9iRdfPUfQjP2h7t87DipnEv3xODOALTLj46g";
        Claims claims = (Claims) JwtUtils.parseToken(token);
        System.out.println(claims);
    }

    public static void main(String[] args) {

    }
}
