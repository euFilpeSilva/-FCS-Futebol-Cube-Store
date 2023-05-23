package br.com.loja.fcs.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO implements Serializable {

    private Long id;

    private String descricao;

    private LocalDate data_pedido;

    private UsuarioDTO usuario;
}
