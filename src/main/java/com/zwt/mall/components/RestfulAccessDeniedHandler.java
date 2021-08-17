package com.zwt.mall.components;

import cn.hutool.json.JSONUtil;
import com.zwt.mall.common.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author zhouwentao
 * @Date 2021-08-12-11:29 上午
 * @Email zhouwt@shuyilink.com
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();

//        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        PrintWriter printWriter = httpServletResponse.getWriter();
//        printWriter.write("{\"status\":403,\"msg\":\"权限不足，请联系管理员\"}");
//        printWriter.flush();
//        printWriter.close();
    }
}
