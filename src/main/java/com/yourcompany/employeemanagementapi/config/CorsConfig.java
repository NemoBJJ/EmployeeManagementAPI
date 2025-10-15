package com.yourcompany.employeemanagementapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                    "*", // ✅ APKs e testes gerais
                    "https://empl.neemindev.com", // ✅ FRONTEND PRINCIPAL
                    "https://employee-container.neemindev.com", // ✅ CONTAINER
                    "https://financial-container.neemindev.com", // ✅ OUTRO CONTAINER
                    "https://apiestoque.neemindev.com" // ✅ OUTRO CONTAINER
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}