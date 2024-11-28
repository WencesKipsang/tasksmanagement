package com.kipsang.tasksmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/addTasks", "/api/updateTask/{id}", "/api/delete/{id}").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()) // Enable HTTP Basic Authentication
                .formLogin(Customizer.withDefaults()); // Enable default form login

        return http.build();
    }
}
