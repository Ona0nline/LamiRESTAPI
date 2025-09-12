package com.onaonline.lami.lami_backend.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;



public class JWT {
    private static final String SECRET = System.getenv("JWT_SECRET");
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
//This line is making a cryptographic signing key from a plain text string (SECRET).
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String email){
        return Jwts.builder().setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();


    }

    public static String validateTokenAndGetEmail(String token){
        try{
            Claims claims = Jwts.parserBuilder().setSigningKey(key)
                    .build().parseClaimsJws(token).getBody();

            return claims.getSubject();
        } catch (JwtException e){
//            invalid token
            return null;
        }
    }
}
