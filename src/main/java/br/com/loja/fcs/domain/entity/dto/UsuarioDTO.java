package br.com.loja.fcs.domain.entity.dto;

import br.com.loja.fcs.domain.ennum.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String sobrenome;

    private String username;

    private String email;

    private String senha;

    private Set<RoleEnum> roles;

}
