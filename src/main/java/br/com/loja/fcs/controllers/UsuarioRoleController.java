//package br.com.loja.fcs.controllers;
//
//import br.com.loja.fcs.domain.entity.Usuario;
//import br.com.loja.fcs.domain.entity.Role;
//import br.com.loja.fcs.services.UsuarioRoleService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/usuarios")
//public class UsuarioRoleController {
//
//    private final UsuarioRoleService usuarioRoleService;
//
//    public UsuarioRoleController(UsuarioRoleService usuarioRoleService) {
//        this.usuarioRoleService = usuarioRoleService;
//    }
//
//    @PostMapping("/{usuarioId}/roles/{roleId}")
//    public ResponseEntity<?> addRoleToUsuario(@PathVariable("usuarioId") Long usuarioId,
//                                              @PathVariable("roleId") Long roleId) {
//        Usuario usuario = //buscar usuario pelo id
//                Role role = //buscar role pelo id
//
//                usuarioRoleService.addRoleToUsuario(role, usuario);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{usuarioId}/roles/{roleId}")
//    public ResponseEntity<?> removeRoleFromUsuario(@PathVariable("usuarioId") Long usuarioId,
//                                                   @PathVariable("roleId") Long roleId) {
//        Usuario usuario = //buscar usuario pelo id
//                Role role = //buscar role pelo id
//
//                usuarioRoleService.removeRoleFromUsuario(role, usuario);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{usuarioId}/roles")
//    public ResponseEntity<?> removeAllRolesFromUsuario(@PathVariable("usuarioId") Long usuarioId) {
//        Usuario usuario = //buscar usuario pelo id
//
//                usuarioRoleService.removeAllRolesFromUsuario(usuario);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
//
