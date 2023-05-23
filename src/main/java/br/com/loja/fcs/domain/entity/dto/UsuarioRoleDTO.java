package br.com.loja.fcs.domain.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioRoleDTO {
    private Long idUser;

    private List<Long> idsRoles;
}
