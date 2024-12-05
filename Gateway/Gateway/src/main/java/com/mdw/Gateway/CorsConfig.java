package com.mdw.Gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));  // Only allow this origin
        corsConfig.setAllowCredentials(true);  // Allow credentials (cookies, authorization headers)
        corsConfig.addAllowedMethod(HttpMethod.GET);  // Allow GET requests
        corsConfig.addAllowedMethod(HttpMethod.POST);  // Allow POST requests
        corsConfig.addAllowedMethod(HttpMethod.PUT);  // Allow PUT requests
        corsConfig.addAllowedMethod(HttpMethod.DELETE);  // Allow DELETE requests
        corsConfig.addAllowedHeader("*");  // Allow all headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);  // Apply to all routes

        return new CorsWebFilter(source);
    }
}
