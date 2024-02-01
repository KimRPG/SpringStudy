package com.pard.oauth2.v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//csrf 설정 꺼둠
        http
                .csrf((csrf) -> csrf.disable());
        //form 로그인 방식 끔
        http
                .formLogin((login) -> login.disable());
        //http basic 방식 끔
        http
                .httpBasic((basic) -> basic.disable());
        //필터라 로그인 방식을 다 해줌
        http
                .oauth2Login(Customizer.withDefaults());

        // "/" "/oauth/**" "/login/**"은 모두다 허용 그 외에는 로그인한 사람만 허용
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/oauth/**", "/login/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }

}
