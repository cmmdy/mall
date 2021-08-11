package com.zwt.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-2:41 下午
 * @Email zhouwt@shuyilink.com
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "redirect:main.html";
    }


    @PostMapping("/toMain")
    public String toMain() {
        return "redirect:main.html";
    }

    @PostMapping("/toFail")
    public String toFail() {
        return "redirect:fail.html";
    }

}
