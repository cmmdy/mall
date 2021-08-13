package com.zwt.mall;

import cn.hutool.core.codec.Base62Codec;
import cn.hutool.core.codec.Base64Decoder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-3:48 下午
 * @Email zhouwt@shuyilink.com
 */

@SpringBootTest
public class SecurityTest {

    @Test
    public void testPwd() {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        String encode = pw.encode("123456");
        System.out.println(encode);

        boolean matches = pw.matches("12356", encode);
        System.out.println(matches);

    }


    @Test
    public void testJwtBUilder() {

        long now = System.currentTimeMillis();

        long exp = now + 60 * 1000000;

        JwtBuilder jwtBuilder = Jwts.builder()
                //jti
                .setId("888")
                //签发用户 sub
                .setSubject("rose")
                //签发时间 iat
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                .setExpiration(new Date(exp))
                //自定义申明
//                .addClaims();
                .claim("logo","xxx.jpg")
                .claim("l111","111.jpg");

        //token令牌
        String token = jwtBuilder.compact();

        String[] tokens = token.split("\\.");
        System.out.println(token);
        System.out.println(Base64Decoder.decodeStr(tokens[0]));
        System.out.println(Base64Decoder.decodeStr(tokens[1]));
        System.out.println(Base64Decoder.decodeStr(tokens[2]));
    }


    @Test
    public void tokenCheck() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJyb3NlIiwiaWF0IjoxNjI4ODM4MTAzLCJleHAiOjE2Mjg4OTgxMDMsImxvZ28iOiJ4eHguanBnIiwibDExMSI6IjExMS5qcGcifQ.4rKl0Li84qj2UUP1KBel0asqaLQBJWleMDHU6iIfrkw";
        Claims claims = Jwts.parser()
                .setSigningKey("xxxx")
                .parseClaimsJws(token)
                .getBody();

        System.out.println("jti: " + claims.getId());
        System.out.println("sub: " + claims.getSubject());
        System.out.println("iat: " + claims.getIssuedAt());
        System.out.println("logo: " + claims.get("logo"));
        System.out.println("l111: " + claims.get("l111"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("过期时间: " + format.format(claims.getExpiration()));
        System.out.println("当前时间: " + format.format(new Date()));


    }
}
