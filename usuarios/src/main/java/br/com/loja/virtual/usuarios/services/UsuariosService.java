package br.com.loja.virtual.usuarios.services;

import br.com.loja.virtual.usuarios.domain.dto.UsuariosDTO;
import br.com.loja.virtual.usuarios.domain.entity.Usuarios;
import br.com.loja.virtual.usuarios.domain.repository.UsuarioRepository;
import br.com.loja.virtual.usuarios.services.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Converter c;

    public List<UsuariosDTO> listarUsuarios() {
        List<Usuarios> blusas = usuarioRepository.findAllByOrderByIdAsc();
        return blusas.stream()
                .map(usuario -> Converter.converter(usuario, UsuariosDTO.class))
                .collect(Collectors.toList());
    }

    public UsuariosDTO buscarUsuario(Long id) {
        Usuarios usuario = usuarioRepository.findById(id).orElse(null);
        return Converter.converter(usuario, UsuariosDTO.class);
    }

    public String updateUsuario(UsuariosDTO usuarioDTO, Long id) {
        Usuarios usuario = Converter.converter(usuarioDTO, Usuarios.class);
        usuarioRepository.save(usuario);
        return "Usuário atualizado com sucesso!";
    }

    public String cadastrarUsuario(UsuariosDTO usuarioDTO) {
        Usuarios usuario = Converter.converter(usuarioDTO, Usuarios.class);
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }
}
