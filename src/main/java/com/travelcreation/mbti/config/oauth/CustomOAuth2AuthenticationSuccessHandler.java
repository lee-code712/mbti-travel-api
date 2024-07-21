package com.travelcreation.mbti.config.oauth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class CustomOAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
        String targetUrl = determineTargetUrl(oauth2User);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(CustomOAuth2User oauth2User) throws UnsupportedEncodingException {
        Map<String, Object> attributes = oauth2User.getAttributes();
        System.out.println("attributes: " + attributes);
        Map<String, String> propertyMap = (Map<String, String>) attributes.get("properties");
        Map<String, String> accountMap = (Map<String, String>) attributes.get("kakao_account");

        String nickname = URLEncoder.encode(propertyMap.get("nickname"), StandardCharsets.UTF_8);
        String email = accountMap.get("email");
        String profile_image_url = propertyMap.get("profile_image");
        if (oauth2User.getNewUserYN()) {
            return "http://localhost:3000/join?nickname=" + nickname + "&email=" + email + "&profile_image=" + profile_image_url;
        } else {
            return "http://localhost:3000/";
        }
    }
}
