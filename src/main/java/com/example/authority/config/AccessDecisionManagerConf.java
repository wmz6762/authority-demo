package com.example.authority.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.Collection;
@Component
public class AccessDecisionManagerConf implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException{
        if(authentication instanceof AnonymousAuthenticationToken)
            throw new BadCredentialsException("BadCredentials");

        for (ConfigAttribute configuration : collection) {
            String needRole = configuration.getAttribute();
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (needRole.equals(authority.getAuthority())) {
                    return;
                }
            }
        }
       throw new AccessDeniedException("AccessDenied");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
