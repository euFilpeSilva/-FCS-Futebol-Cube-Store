//package br.com.loja.fcs.services;
//
//import br.com.loja.fcs.domain.entity.Role;
//import br.com.loja.fcs.domain.entity.Usuario;
//import br.com.loja.fcs.domain.repository.RoleRepository;
//import br.com.loja.fcs.domain.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class UsuarioRoleServiceImpl implements UsuarioRoleService {
//
//    private final UsuarioRepository usuarioRepository;
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    public UsuarioRoleServiceImpl(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
//        this.usuarioRepository = usuarioRepository;
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public void adicionarRoleAoUsuario(Long usuarioId, Long roleId) {
//        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
//        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada"));
//
//        List<Role> rolesUsuario = usuario.getRoles();
//        rolesUsuario.add(role);
//        usuario.setRoles(rolesUsuario);
//        usuarioRepository.save(usuario);
//    }
//
//    @Override
//    public void removerRoleDoUsuario(Long usuarioId, Long roleId) {
//        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
//        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada"));
//
//        List<Role> rolesUsuario = usuario.getRoles();
//        rolesUsuario.remove(role);
//        usuario.setRoles(rolesUsuario);
//        usuarioRepository.save(usuario);
//    }
//
//    @Override
//    public void addRoleToUsuario(Role role, Usuario usuario) {
//
//    }
//
//    @Override
//    public void removeRoleFromUsuario(Role role, Usuario usuario) {
//
//    }
//
//    @Override
//    public void removeAllRolesFromUsuario(Usuario usuario) {
//
//    }
//}
