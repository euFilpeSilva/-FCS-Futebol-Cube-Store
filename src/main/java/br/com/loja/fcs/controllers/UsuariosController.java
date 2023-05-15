package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.dto.UsuarioDTO;

import br.com.loja.fcs.domain.ennum.RoleName;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import br.com.loja.fcs.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<UsuarioDTO>> listarUsuario(String username) {
        return new ResponseEntity<>(usuariosService.listarUsuario(username), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuariosService.buscarUsuario(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) {
        return new ResponseEntity<>(usuariosService.updateUsuario(usuarioDTO, id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.cadastrarUsuario(usuarioDTO), HttpStatus.OK);
    }

    @PostMapping("/{id}/roles")
    public String adicionarRolesAoUsuario(@PathVariable Long id, @RequestBody List<RoleName> roleNames) {
        usuariosService.adicionarRolesAoUsuario(id, roleNames);
        return "Roles adicionadas com sucesso!";
    }

    @DeleteMapping("/{id}/roles")
    public ResponseEntity<String> removerRolesDoUsuario(@PathVariable Long id, @RequestBody List<RoleName> roleNames) {
        usuariosService.removerRolesDoUsuario(id, roleNames);
        return ResponseEntity.ok("Roles removidas com sucesso do usuário.");
    }

}
