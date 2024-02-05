package com.pard.oauth2.v1.entity;

import com.pard.oauth2.v1.dto.JoinDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    public static UserEntity toEntity(JoinDTO dto, String role) {
        return UserEntity.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(role)
                .build();
    }

}
