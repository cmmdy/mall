package com.zwt.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-4:02 下午
 * @Email zhouwt@shuyilink.com
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //1.根据username查询数据库
        if (!"admin".equals(s)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        //2.根据查询的对象比较密码
//        if (!pw.matches("123456", "123456")) {
//            throw new UsernameNotFoundException("用户名或密码错误");
//        }
        String encode = pw.encode("123456");
        //3.返回用户对象

        return new User("admin", encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
