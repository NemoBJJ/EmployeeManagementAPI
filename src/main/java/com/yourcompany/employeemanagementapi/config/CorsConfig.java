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
        registry.addMapping("/api/**") // 🟢 Define o padrão de URL para aplicar o CORS
                .allowedOrigins(
                    "https://apifrontemployeenemin.netlify.app", // Frontend no Netlify
                    "https://empl.neemindev.com", // Subdomínio personalizado (frontend)
                    "https://apiempl.neemindev.com" // Subdomínio do backend (Load Balancer)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Todos os cabeçalhos permitidos
                .allowCredentials(true); // Permite credenciais (cookies, autenticação)
    }
}