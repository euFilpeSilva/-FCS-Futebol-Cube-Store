package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.entity.Usuario;
import br.com.loja.fcs.domain.entity.dto.UsuarioRoleDTO;
import br.com.loja.fcs.domain.repository.UsuarioRepository;
import br.com.loja.fcs.services.UsuarioRoleService;
import br.com.loja.fcs.services.UsuariosService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuarios API", description = "Endpoints para gerenciamento de usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService createUserService;

    @Autowired
    UsuarioRoleService createRoleUserService;

    @PreAuthorize("hasRole('ADMIN)")
    @PostMapping("/create")
    public Usuario create(@RequestBody Usuario user) {

        return createUserService.execute(user);
    }

    @PreAuthorize("hasRole('ADMIN)")
    @PostMapping("/role")
    public Usuario role(@RequestBody UsuarioRoleDTO createUserRoleDTO) {
        return createRoleUserService.execute(createUserRoleDTO);
    }

}
