package net.voll.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import net.voll.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String create(User user) {
        try {
            return JWT.create()
                    .withIssuer("Backend API Voll.med")
                    .withSubject(user.getUsername())
                    .withExpiresAt(setExpiration())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error when try to create JWT token", e);
        }
    }

    public String validate(String jwtToken) {
        try {
            return JWT
                    .require(Algorithm.HMAC256(secret))
                    .withIssuer("Backend API Voll.med")
                    .build()
                    .verify(jwtToken)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Toke was invalid or expires", e);
        }
    }

    private Instant setExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
