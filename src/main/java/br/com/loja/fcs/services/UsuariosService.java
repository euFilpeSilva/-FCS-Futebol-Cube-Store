package br.com.loja.fcs.services;

import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    UsuarioRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Usuario execute(Usuario user) {

        Usuario existsUser = userRepository.findByUsername(user.getUsername());

        if (existsUser != null) {
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        Usuario createdUser = userRepository.save(user);

        return createdUser;
    }

}
