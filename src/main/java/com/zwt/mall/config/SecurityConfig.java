package com.zwt.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-4:00 下午
 * @Email zhouwt@shuyilink.com
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录 自定义登录页面
        http.formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/toMain")
//                .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com"))
                .failureHandler(new MyAuthenticationFailHandler("https://www.google.com"));


        //授权 所有请求都必须被认证(登录）
        http.authorizeRequests()
//                .antMatchers("/login.html").permitAll()
//                .antMatchers("/fail.html").permitAll()
                .antMatchers("/ouath/**", "/login/**", "logout/**").permitAll()
//                .antMatchers("/main.html").hasRole("adbd")
//                .anyRequest().access("@myAccessServiceImpl.hasPermission(request,authentication)");
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();

        //异常处理
        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder pw() {
        return new BCryptPasswordEncoder();
    }
}
