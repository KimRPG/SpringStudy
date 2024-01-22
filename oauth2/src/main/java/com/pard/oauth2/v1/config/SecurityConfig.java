//package com.pard.oauth2.v1.config;
//
//
////import com.kidsworld.auth.oauth.service.MyAuthenticationSuccessHandler;
////import com.kidsworld.auth.oauth.service.OAuthService;
//import com.pard.oauth2.v1.service.OAuthService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final OAuthService oAuthService;
//
//    public SecurityConfig(OAuthService oAuthService) {
//        this.oAuthService = oAuthService;
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .cors().and()
//                .csrf().disable()
//                .httpBasic().disable()
//                .formLogin().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests(authorize -> authorize.requestMatchers("/signin","signup").permitAll())
//                .anyRequest().permitAll().and()
//                .oauth2Login()
//                .successHandler(new MyAuthenticationSuccessHandler())
//                .userInfoEndpoint()
//                .userService(oAuthService)
//                .and()
//                .build();
//    }
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://localhost:3000");
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
