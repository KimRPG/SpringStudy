package com.pard.oauth2.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/v1/main", "/v1/login" ,"/v1/join", "/v1/joinProc").permitAll()
                        .requestMatchers("/v1/admin").hasRole("ADMIN")
                        .requestMatchers("/v1/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated() //
                );

        http
                .formLogin((auth) -> auth.loginPage("/v1/login") //로그인 페이지로 바로 redirection
                        .loginProcessingUrl("/v1/loginProc") //
                        .permitAll()
                );

        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}
