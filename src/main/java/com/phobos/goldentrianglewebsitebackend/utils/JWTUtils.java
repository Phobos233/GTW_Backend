package com.phobos.goldentrianglewebsitebackend.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String secret="GTPWBackEnd";
    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();
    public static String generateToken(Map<String, String> map) {
        // 获取当前日期
        Calendar instance = Calendar.getInstance();
        // 默认7天过期
        instance.add(Calendar.DATE, 7);
        // 创建token
        String token=Jwts.builder()
                .signWith(secretKey)
                .claims(map)
                .expiration(instance.getTime())
                .compact();
        System.out.println(token);
        return token;
    }
    public static String parseToken(String token) {

        Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
        System.out.println(claims);
        return claims.toString();

    }

}
