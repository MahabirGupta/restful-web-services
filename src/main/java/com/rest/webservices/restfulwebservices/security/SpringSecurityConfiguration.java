package com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

//    create a Bean
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        1. All requests are authenticated
        http.authorizeHttpRequests(
//                define the logic and authenticate all requests
                auth -> auth.anyRequest().authenticated()
        );
//		2) If a request is not authenticated, a web page is shown
        http.httpBasic(withDefaults());

//		3) CSRF -> POST, PUT
        // http.csrf().disable(); // Deprecated in SB 3.1.x
        http.csrf(csrf -> csrf.disable()); // Starting from SB 3.1.x Using Lambda DSL
        // OR
        // http.csrf(AbstractHttpConfigurer::disable); // Starting from SB 3.1.x Using Method Reference


        return http.build();
    }
    }

