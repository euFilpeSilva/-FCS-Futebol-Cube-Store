package br.com.loja.fcs.config.auth_jwt;

import br.com.loja.fcs.config.security.UserPrincipal;
import br.com.loja.fcs.domain.entity.Role;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        List<String> roleNames = userPrincipal.getRoles().stream()
                .map(Role::getName) // Obtém apenas o nome das roles
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("id", userPrincipal.getId())
                .claim("username", userPrincipal.getUsername())
                .claim("password", userPrincipal.getPassword())
                .claim("roles", roleNames) // Adiciona as roles como uma claim de lista de strings
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

