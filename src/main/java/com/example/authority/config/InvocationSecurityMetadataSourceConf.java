package com.example.authority.config;


import org.assertj.core.util.Maps;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class InvocationSecurityMetadataSourceConf implements FilterInvocationSecurityMetadataSource {

    private HashMap<String, String[]> map = null;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    private void loadResourceDefine() {
        map = new HashMap<>();
        map.put("/",new String[]{"public"});
        map.put("/account/**", new String[]{"admin"});
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (map == null) loadResourceDefine();
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        for(String url : map.keySet()){
            if (antPathMatcher.match(url, requestUrl))
                return SecurityConfig.createList(map.get(url));
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
