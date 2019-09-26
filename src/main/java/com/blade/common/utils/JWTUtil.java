package com.blade.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 *
 * @author lyq
 * @create 8/15/19
 */
public class JWTUtil {

    /**
     * 生成jwt token
     * @param sub jwt签发用户id
     * @param secret 秘钥
     * @param expiration 过期时间（秒）
     * @return
     */
    public static String generateToken(String sub,String secret,Long expiration){
        return Jwts.builder().setSubject(sub).setExpiration(generateExpirationDate(expiration)).signWith(SignatureAlgorithm.HS256,secret).compact();
    }

    /**
     * 生成过期时间
     * @param expiration
     * @return
     */
    public static Date generateExpirationDate(Long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 解析token,获取用户名
     * @param token
     * @param secret
     * @return
     */
    public static String parseToken(String token,String secret){
        Claims claims = (Claims) Jwts.parser().setSigningKey(secret).parse(token).getBody();
        Object name = claims.get("user_name");
        if (name == null) {
            return null;
        } else {
            return name.toString();
        }
    }

    /**
     * 校验token是否过期
     * @param token
     * @return
     */
    public static Boolean checkTokenExpire(String token,String secret){
        Claims claims = (Claims) Jwts.parser().setSigningKey(secret).parse(token).getBody();
        return new Date().after(claims.getExpiration()) ? true : false;
    }

}
