package com.kh.app.security.util;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;

    @Value("${jwt.expiration}")
    private Long expirationMs;

    public JwtUtil(@Value("${jwt.secret}") String secretStr){
        byte[] bytes = secretStr.getBytes(StandardCharsets.UTF_8);
        String algorithm = Jwts.SIG.HS256.key().build().getAlgorithm(); //HmacSHA256
        this.secretKey = new SecretKeySpec(bytes,algorithm);
    }

    //JWT 생성(토큰 생성)
    public String createJwt(String username, String role){
        return Jwts.builder()
                .claim("username",username)
                .claim("role",role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(secretKey)
                .compact();
    }

    //JWT 에서 username 추출
    public String  getUsername(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("username", String.class);
    }
    //JWT 에서 role 추출
    public String getRole(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }
    //JWT 만료 여부 체크
    public boolean isExpired(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }
}
