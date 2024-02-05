package com.pard.oauth2.v1.service;

import com.pard.oauth2.v1.dto.JoinDTO;
import com.pard.oauth2.v1.entity.UserEntity;
import com.pard.oauth2.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        if(!userRepository.existsByUsername(joinDTO.getUsername())){
            joinDTO.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
            userRepository.save(UserEntity.toEntity(joinDTO, "ROLE_USER"));
        }

    }
}
