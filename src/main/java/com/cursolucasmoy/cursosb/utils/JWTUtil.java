package com.cursolucasmoy.cursosb.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.ttl}")
    private long ttlMillis;

    public String create(String id, String subject) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Nueva función para verificar el token
    public boolean verifyToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

            // Parsear el token y verificar su validez
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .requireIssuer(issuer) // Verifica que el issuer coincida
                    .build()
                    .parseClaimsJws(token);

            // Si no lanza excepción, el token es válido
            return true;
        } catch (Exception e) {
            // Cualquier error (firma inválida, token expirado, malformado, etc.) indica token inválido
            return false;
        }
    }

    // Función auxiliar para obtener los claims del token (opcional, si necesitas acceder a los datos)
    public Claims getClaims(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }
}