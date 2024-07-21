package com.travelcreation.mbti.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    /**
     * 카카오로부터 받은 userRequest 데이터에 대해 후처리하는 함수
     * @param userRequest
     * @return
     * @throws OAuth2AuthenticationException
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest: " + userRequest.getClientRegistration());
        System.out.println("userRequest: " + userRequest.getAccessToken());
        System.out.println("userRequest: " + super.loadUser(userRequest).getAttributes());
        return super.loadUser(userRequest);
    }

}
