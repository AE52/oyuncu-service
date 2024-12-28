package com.example.oyuncuservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // "/api/**" yoluna gelen tüm istekler için CORS'u etkinleştir
        registry.addMapping("/**")
                .allowedOrigins("*") // Frontend domainlerinizi burada belirtin
                .allowedMethods("*") // İzin verilen HTTP metotları
                .allowedHeaders("*"); // İzin verilen başlıklar
    }
}
