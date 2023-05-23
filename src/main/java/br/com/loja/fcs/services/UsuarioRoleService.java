package br.com.loja.fcs.services;

import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.entity.Role;
import br.com.loja.fcs.domain.entity.dto.UsuarioRoleDTO;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioRoleService {

    @Autowired
    UsuarioRepository userRepository;

    public Usuario execute(UsuarioRoleDTO createUserRoleDTO) {

        Optional<Usuario> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }

        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        Usuario user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;

    }

}
