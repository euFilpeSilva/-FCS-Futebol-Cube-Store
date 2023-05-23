package br.com.loja.fcs.controllers;

import br.com.loja.fcs.config.auth_jwt.JwtTokenProvider;
import br.com.loja.fcs.config.security.UserPrincipal;
import br.com.loja.fcs.config.security.requests.LoginRequest;
import br.com.loja.fcs.config.security.responses.AuthResponse;
import br.com.loja.fcs.services.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsuariosService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UsuariosService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Autenticar o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // Gerar o token JWT
        String token = jwtTokenProvider.generateToken(authentication);

        // Obter informações do usuário autenticado
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        // Criar um objeto de resposta contendo o token JWT e as informações do usuário
        AuthResponse response = new AuthResponse( token);

        return ResponseEntity.ok(response);
    }
}

