package com.pard.oauth2.v1.repository;

import com.pard.oauth2.v1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
