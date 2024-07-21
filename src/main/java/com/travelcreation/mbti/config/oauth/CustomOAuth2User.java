package com.travelcreation.mbti.config.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {

    private OAuth2User oauth2User;
    private boolean newUserYN;

    public CustomOAuth2User(OAuth2User oauth2User, Boolean newUserYN) {
        this.oauth2User = oauth2User;
        this.newUserYN = newUserYN;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getName() {
        return oauth2User.getName();
    }

    public Boolean getNewUserYN() {
        return newUserYN;
    }
}