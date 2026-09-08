package com.phoniex.blog.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static String SECRET_STRING = "y97aRNf5CW0E26aMrISKWHnvwjQCvrm9sMlPjMrrrYI=";
//    private static Key key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    private static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));

    private static final long EXPIRATION = 2 * 60 * 60 * 1000L;
    public static String getToken(Map<String,Object> claims){
        String compact = Jwts.builder()
            .setClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(key)
            .compact();

        return compact;
    }

    public static Claims parseToken(String token) {
        if (!StringUtils.hasLength(token)) {
            return null;
        }
        JwtParser builder = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = null;
        try {
            claims = builder.parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("token解析失败,token:" + token);
        }
        return claims;
    }

}
