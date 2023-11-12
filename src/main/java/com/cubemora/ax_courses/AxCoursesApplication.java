package com.cubemora.ax_courses;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AxCoursesApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(AxCoursesApplication.class, args);
    }

     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AxCoursesApplication.class);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
    
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*", "TRACE"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Vaporeon", "C deisote", "Sexo", "rata"));
        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type", "Vaporeon", "C deisote", "Sexo", "rata"));
    
        source.registerCorsConfiguration("/**", config);
    
        return new CorsFilter(source);
    }

}
