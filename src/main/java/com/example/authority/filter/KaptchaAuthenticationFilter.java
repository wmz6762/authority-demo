package com.example.authority.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class KaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public  KaptchaAuthenticationFilter(){
        AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/login", "POST");
        this.setRequiresAuthenticationRequestMatcher(requestMatcher);
        this.setAuthenticationManager(getAuthenticationManager());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String uuid = request.getParameter("uuid");//从请求信息中获取uuid码
//        String captcha="";//从session或者redis中获取验证码图片
//        if(captcha.contentEquals(uuid)){
//            抛出异常
//        }


        return super.attemptAuthentication(request, response);
    }
}
