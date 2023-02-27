package com.miportfolio.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NicoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200","https://nicoportfolioweb.web.app").allowedMethods("*").allowedHeaders("*");
                //registry.addMapping("/**").allowedOrigins("https://nicoportfolioweb.web.app").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
}
