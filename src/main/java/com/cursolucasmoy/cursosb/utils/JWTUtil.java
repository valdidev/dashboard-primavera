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
    private String secret;  // Debe ser una cadena Base64 segura

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.ttl}")
    private long ttlMillis;

    public String create(String id, String subject) {
        // 1. Convertir la clave secreta (Base64) a una clave HMAC-SHA256
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        // 2. Generar el token JWT
        return Jwts.builder()
                .setId(id)                      // ID del usuario (puede ser su ID de BD)
                .setSubject(subject)            // Email o username
                .setIssuer(issuer)              // Quién emite el token
                .setIssuedAt(new Date())        // Fecha de creación
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis))  // Fecha de expiración
                .signWith(key, SignatureAlgorithm.HS256)  // Firma con clave secreta
                .compact();                     // Genera el token como String
    }
}