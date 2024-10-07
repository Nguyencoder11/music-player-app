package com.app.msplayer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)   // tat csrf cho cac API
                .authorizeRequests(auth -> auth
                    // Cac endpoint danh cho admin
                    .requestMatchers("/api/admin/**").hasRole("ADMIN")

                    // Cac endpoint danh cho USER va ADMIN
                    .requestMatchers("/api/users/**").hasAnyRole("USER", "ADMIN")

                    // cho phep truy cap cac endpoint nay ma k can xac thuc
                    .requestMatchers("/public/**", "/api/auth/**").permitAll()

                    // cac yeu cau khac can phai xac thuc
                    .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
