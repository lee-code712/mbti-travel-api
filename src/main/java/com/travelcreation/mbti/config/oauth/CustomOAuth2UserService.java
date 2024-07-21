package com.travelcreation.mbti.config.oauth;

import com.travelcreation.mbti.domain.member.entity.ServiceUserSNS;
import com.travelcreation.mbti.domain.member.repository.ServiceUserSNSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final ServiceUserSNSRepository serviceUserSNSRepo;

    /**
     * 플랫폼으로부터 받은 userRequest 데이터에 대해 후처리하는 함수
     * @param userRequest
     * @return
     * @throws OAuth2AuthenticationException
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oauth2User.getAttributes();
        System.out.println("attributes: " + attributes);
        Map<String, String> accountMap = (Map<String, String>) attributes.get("kakao_account");

        // 1. 이메일 + 플랫폼으로 회원이 존재하는지 확인
        String platform = userRequest.getClientRegistration().getRegistrationId().toUpperCase();
        String email = accountMap.get("email");

        System.out.println("platform: " + platform + ", email: " + email);

        ServiceUserSNS snsUser = serviceUserSNSRepo.findByUserEmailAndPlatform(email, ServiceUserSNS.PLATFORM.valueOf(platform))
                .orElse(null);

        // DB 업데이트

        return new CustomOAuth2User(oauth2User, snsUser == null); // 회원이 존재하면 newUserYN=false, 아니면 newUserYN=true
    }

}
