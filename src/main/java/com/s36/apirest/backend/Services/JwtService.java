package com.s36.apirest.backend.Services;

import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    public String SecretKey = System.getenv("JWT_SECRET_KEY");
    public Long Expiration = System.getenv("JWT_EXPIRATION") != null ? Long.parseLong(System.getenv("JWT_EXPIRATION")) : 3600000L;

    public String generateToken(String id, String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + Expiration);
        
        return Jwts.builder()
                .claim("Id", id)
                .subject(email)
                .issuer("JavaBackend.com")
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key())
                .compact();
    }
    
    private Key key() {
        return Keys.hmacShaKeyFor(SecretKey.getBytes());
    }
}
