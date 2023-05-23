package br.com.loja.fcs.config.security;

import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario existsUser = userRepository.findByUsername(username);

        if (existsUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return UserPrincipal.create(existsUser);
    }

}

