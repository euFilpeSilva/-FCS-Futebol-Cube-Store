package br.com.loja.virtual.usuarios.controllers;

import br.com.loja.virtual.usuarios.domain.dto.UsuariosDTO;
import br.com.loja.virtual.usuarios.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> listarUsuarios() {
        return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDTO> buscarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuariosService.buscarUsuario(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@RequestBody UsuariosDTO usuarioDTO, @PathVariable Long id) {
        return new ResponseEntity<>(usuariosService.updateUsuario(usuarioDTO, id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.cadastrarUsuario(usuarioDTO), HttpStatus.OK);
    }
}
