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
                .allowedOrigins("http://localhost:3000", "https://oyuncu-service-597129445396.us-central1.run.app") // Frontend domainlerinizi burada belirtin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metotları
                .allowedHeaders("*"); // İzin verilen başlıklar
    }
}
