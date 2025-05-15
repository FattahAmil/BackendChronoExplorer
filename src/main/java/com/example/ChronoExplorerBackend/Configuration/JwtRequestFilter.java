package com.example.ChronoExplorerBackend.Configuration;

import com.example.ChronoExplorerBackend.Service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component  // Utiliser @Component pour enregistrer le filtre avec Spring
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Value("${jwt.secret}")
    private String secretKey;

    private final UserService userService;

    public JwtRequestFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            String token = jwtToken.substring(7);

            try {
                Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

                JwtParser jwtParser = Jwts.parser()
                        .setSigningKey(key)
                        .build();

                Claims claims = jwtParser.parseClaimsJws(token).getBody();

                String username = claims.getSubject();
                if (username != null) {
                    SecurityContextHolder.getContext().setAuthentication(new JwtAuthentication(username));
                }
            } catch (Exception e) {
                logger.warn("JWT Token is invalid", e);
            }
        }

        filterChain.doFilter(request, response);
    }
}