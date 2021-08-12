package com.zwt.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.stereotype.Component;

/**
 * @Author zhouwentao
 * @Date 2021-08-12-23:01
 * @Email zhouwt@shuyilink.com
 */
@Configuration
@EnableAuthorizationServer
public class AuthenticationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret(passwordEncoder.encode("123"))
                .redirectUris("https://www.baidu.com")
                .scopes("all")
                .authorizedGrantTypes("authorization_code");

    }
}
