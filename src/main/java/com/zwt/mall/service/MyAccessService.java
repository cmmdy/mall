package com.zwt.mall.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhouwentao
 * @Date 2021-08-12-11:39 上午
 * @Email zhouwt@shuyilink.com
 */
public interface MyAccessService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
