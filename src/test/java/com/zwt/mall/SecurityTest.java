package com.zwt.mall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-3:48 下午
 * @Email zhouwt@shuyilink.com
 */

@SpringBootTest
public class SecurityTest {

   @Test
   public void testPwd(){
      PasswordEncoder pw = new BCryptPasswordEncoder();
      String encode = pw.encode("123456");
      System.out.println(encode);

      boolean matches = pw.matches("12356", encode);
      System.out.println(matches);

   }
}
