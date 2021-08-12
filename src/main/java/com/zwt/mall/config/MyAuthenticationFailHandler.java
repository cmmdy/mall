package com.zwt.mall.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-5:00 下午
 * @Email zhouwt@shuyilink.com
 */

public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private final String url;


    public MyAuthenticationFailHandler(String url) {
        this.url = url;
    }


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(url);
    }
}