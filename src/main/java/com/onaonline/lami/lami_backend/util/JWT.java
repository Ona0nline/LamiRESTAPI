package com.onaonline.lami.lami_backend.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;



public class JWT {
    private static final String SECRET = "f63f0e02a73b4c4f89e2e2a12d2b7a1d3fbbfdad16e174ac4af9a02f5e8c6cf2a9a84c1d9f4f2e3a97e40a84f6dc121bf8c1a0c917ed4dcb6f912a1b3bb53e32";
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
