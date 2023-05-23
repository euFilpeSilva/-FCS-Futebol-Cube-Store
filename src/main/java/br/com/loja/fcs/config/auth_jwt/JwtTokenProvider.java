package br.com.loja.fcs.config.auth_jwt;

import br.com.loja.fcs.config.security.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${loja.fcs.jwtSecret}")
    private String jwtSecret;

    @Value("${loja.fcs.jwtExpirationMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("id", userPrincipal.getId()) // Adiciona o ID do usuário como uma claim
                .claim("username", userPrincipal.getUsername()) // Adiciona o username do usuário como uma claim
                .claim("password", userPrincipal.getPassword()) // Adiciona a password do usuário como uma claim
                .claim("roles", userPrincipal.getRoles()) // Adiciona as roles do usuário como uma claim
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("Token inválido: " + ex.getMessage());
        } catch (ExpiredJwtException ex) {
            System.out.println("Token expirado: " + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Token não suportado: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("Token vazio ou nulo: " + ex.getMessage());
        }
        return false;
    }
}

