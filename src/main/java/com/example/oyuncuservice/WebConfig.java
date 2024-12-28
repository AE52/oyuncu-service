package com.example.oyuncuservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // sadece "/api" yolundaki istekler için
                .allowedOrigins("https://oyuncu-service-597129445396.us-central1.run.app", "http://localhost:3000") // doğru frontend domainler
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // izin verilen HTTP metotları
                .allowedHeaders("*");

    }
}
