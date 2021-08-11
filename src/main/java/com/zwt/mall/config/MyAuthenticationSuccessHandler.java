package com.zwt.mall.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-5:00 下午
 * @Email zhouwt@shuyilink.com
 */

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String url;


    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(url);
    }


}
