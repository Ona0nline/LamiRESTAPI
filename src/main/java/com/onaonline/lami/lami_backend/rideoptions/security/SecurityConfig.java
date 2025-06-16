package com.onaonline.lami.lami_backend.rideoptions.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        Cross site request forgery protection not neccessary because vele the api and client are on different sites and state changes will be made my json objects
//         Public access to /home
//.anyRequest().authenticated(): All other endpoints still require login if needed
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
