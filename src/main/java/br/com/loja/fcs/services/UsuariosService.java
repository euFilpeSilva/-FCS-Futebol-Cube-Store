package br.com.loja.fcs.services;

import br.com.loja.fcs.converter.Converter;
import br.com.loja.fcs.domain.dto.UsuarioDTO;
import br.com.loja.fcs.domain.ennum.RoleName;
import br.com.loja.fcs.domain.entity.Role;
import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.repository.RoleRepository;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private Converter c;

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAllByOrderByIdAsc();
        return usuarios.stream()
                .map(usuario -> {
                    UsuarioDTO usuarioDTO = Converter.converter(usuario, UsuarioDTO.class);
                    usuarioDTO.setRoles(usuario.getRoles().stream()
                            .map(Role::getNomeRole)
                            .collect(Collectors.toList()));
                    return usuarioDTO;
                })
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarUsuario(String username) {
        Optional<Usuario> blusas = usuarioRepository.findByUsername(username);
        return blusas.stream()
                .map(usuario -> Converter.converter(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return Converter.converter(usuario, UsuarioDTO.class);
    }

    public String updateUsuario(UsuarioDTO usuarioDTO, Long id) {
        Usuario usuario = Converter.converter(usuarioDTO, Usuario.class);

        // Verificar se a senha foi modificada
        if (usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isEmpty()) {
            // Criptografar a nova senha
            String senhaCriptografada = criptografarSenha(usuarioDTO.getSenha());
            usuario.setSenha(senhaCriptografada);
        }

        usuarioRepository.save(usuario);
        return "Usuário atualizado com sucesso!";
    }

    public String cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = Converter.converter(usuarioDTO, Usuario.class);

        // Criptografar a senha
        String senhaCriptografada = criptografarSenha(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public void adicionarRolesAoUsuario(Long idUsuario, List<RoleName> roleNames) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        List<Role> roles = new ArrayList<>();
        for (RoleName roleName : roleNames) {
            Role role = roleRepository.findByNomeRole(roleName)
                    .orElseThrow(() -> new IllegalArgumentException("Role não encontrada"));
            roles.add(role);
        }

        usuario.getRoles().addAll(roles);

        // Salvar o usuário apenas se você quiser que outras alterações também sejam salvas
        usuarioRepository.save(usuario);
    }


    public void removerRolesDoUsuario(Long idUsuario, List<RoleName> roleNames) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        List<Role> rolesRemover = usuario.getRoles().stream()
                .filter(role -> roleNames.contains(role.getNomeRole()))
                .collect(Collectors.toList());

        usuario.getRoles().removeAll(rolesRemover);

        usuarioRepository.save(usuario);
    }


}
