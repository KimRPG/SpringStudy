package com.pard.oauth2.v1.service;

import com.pard.oauth2.v1.dto.CustomUserDetails;
import com.pard.oauth2.v1.entity.UserEntity;
import com.pard.oauth2.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(NullPointerException::new);

        return new CustomUserDetails(user);
    }
}
