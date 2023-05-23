package br.com.loja.fcs.config.security;

import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario existsUser = userRepository.findByUsernameFetchRoles(username);

        if (existsUser == null) {
            throw new Error("User does not exists!");
        }

        return UserPrincipal.create(existsUser);
    }

}
