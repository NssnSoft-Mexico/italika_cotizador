// package com.example.demo.securityConfiguration;

// import io.jsonwebtoken.*;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;
// import java.util.List;
// import java.util.stream.Collectors;


// @Component
// public class JWTAuthorizationFilter extends OncePerRequestFilter {

//    private Claims seSigningKey(HttpServletRequest request) {
//         String jwtToken = request.
//             getHeader(HEADER_AUTHORIZATION_KEY).
//             replace(TOKEN_PREFIX, "");
        
//         return Jwts.parserBuilder()
//             .setSigningKey(getSigningKey(SUPER_SECRET_KEY))
//             .build()
//             .parseClaimsJws(jwtToken)
//             .getBody();
//    }

//    private void setAuthentication(Claims claims) {
    
//         List<String> authorities = (List<String>) claims.get("authorities");

//         UsernamePasswordAuthenticationToken auth =
//             new UsernamePasswordAuthenticationToken(claims.getSubject(), null, 
//                 authorities.stream()
//                     .map(SimpleGrantedAuthority::new)
//                     .collect(Collectors.toList()));
        
//         SecurityContextHolder.getContext().setAuthentication(authentication);
//    }

//    private boolean isJWTValid(HttpServletRequest request, HttpServletResponse res) {
//         String authenticationHeader = request.getHeader(HEADER_AUTHORIZATION_HEY);
//         if(authenticationHeader == null || !authenticationHeader.startsWith(TOKEN_BEARER_PREFIX)) {
//             return false;
//         }
//    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//       try {
//          if (isJWTValid(request, response)) {
//             Claims claims = setSigningKey(request);
//             if (claims.get("authorities") != null) {
//                setAuthentication(claims);
//             } else {
//                SecurityContextHolder.clearContext();
//             }
//          } else {
//             SecurityContextHolder.clearContext();
//          }
//          filterChain.doFilter(request, response);
//       } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
//          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//          response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//          return;
//       }
//    }
// }
