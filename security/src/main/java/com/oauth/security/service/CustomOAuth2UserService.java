package com.oauth.security.service;

import com.oauth.security.dto.CustomOAuth2User;
import com.oauth.security.dto.GoogleResponse;
import com.oauth.security.dto.OAuth2Response;
import com.oauth.security.dto.UserDTO;
import com.oauth.security.entity.UserEntity;
import com.oauth.security.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;
        if (registrationId.equalsIgnoreCase("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            return null;
        }

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId(); // 우리서버에서 특정할 이름
        UserEntity existDate = userRepository.findByUsername(username);

        if (existDate == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setEmail(oAuth2Response.getEmail());
            userEntity.setName(oAuth2Response.getName());
            userEntity.setRole("ROLE_USER");

            userRepository.save(userEntity);

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(username);
            userDTO.setName(oAuth2Response.getName());
            userDTO.setRole("ROLE_USER");

            return new CustomOAuth2User(userDTO);

        } else {
            existDate.setEmail(oAuth2Response.getEmail());
            existDate.setName(oAuth2Response.getName());

            userRepository.save(existDate);

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(existDate.getUsername());
            userDTO.setName(oAuth2User.getName());
            userDTO.setRole(existDate.getRole());

            return new CustomOAuth2User(userDTO);
        }
    }
}
