package com.cubemora.ax_courses;

import java.util.Arrays;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AxCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxCoursesApplication.class, args);
	}

	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

       
        config.setAllowedOrigins(Arrays.asList("*"));

       
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

        
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }


}
