package br.com.loja.fcs.domain.dto;

import br.com.loja.fcs.domain.ennum.RoleName;
import br.com.loja.fcs.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private List<RoleName> roles;

}
