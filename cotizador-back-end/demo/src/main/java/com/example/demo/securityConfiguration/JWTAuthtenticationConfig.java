// package com.example.demo.securityConfiguration;

// import java.util.List;

// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JWTAuthtenticationConfig {

//     public String getJWTToken(String username) {
//         List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                 .commaSeparatedStringToAuthorityList("ROLE_USER");

//         String token = Jwts
//                 .builder()
//                 .setId("espinozajgeJWT")
//                 .setSubject(username)
//                 .claim("authorities",
//                         grantedAuthorities.stream()
//                                 .map(GrantedAuthority::getAuthority)
//                                 .collect(Collectors.toList()))
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
//                 .signWith(getSigningKey(SUPER_SECRET_KEY),  SignatureAlgorithm.HS512).compact();

//         return "Bearer " + token; 
//     }
// }