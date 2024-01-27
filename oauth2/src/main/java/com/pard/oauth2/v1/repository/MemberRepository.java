//package com.pard.oauth2.v1.repository;
//
//import com.pard.oauth2.v1.domain.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface MemberRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByEmailAndProvider(String email, String provider);
//    Boolean existsByEmail(String email);
//}