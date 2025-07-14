// package com.example.demo.securityConfiguration;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @EnableWebSecurity
// @Configuration
// public class WebSecurityConfig {

//     @Autowired
//     JWTAuthorizationFilter jwtAuthorizationFilter;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf((csrf) -> csrf
//                     .disable())
//             .authorizeHttpRequests( authz -> authz
//                 .requestMatchers(HttpMethod.POST, "/api/inventario").permitAll()
//                 .anyRequest().authenticated())
//             .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//         return http.build();
//     }
// }
