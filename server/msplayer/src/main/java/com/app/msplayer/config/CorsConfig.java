package com.app.msplayer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // cho tat ca duong dang API
                        .allowedOrigins("http://localhost:3000")    // cho phep frontend ReactJS
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // cho phep cac METHOD
                        .allowedHeaders("*")    // cho phep tat ca headers
                        .allowCredentials(true);    // cho phep gui cookie neu can
            }
        };
    }
}
