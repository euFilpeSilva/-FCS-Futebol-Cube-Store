package br.com.loja.virtual.usuarios.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDTO implements Serializable {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;
}
