package br.com.loja.fcs.domain.dto;

import br.com.loja.fcs.domain.entity.Pedido;
import br.com.loja.fcs.domain.entity.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItensPedidoDTO {

    private Long id; //(chave primária)
    private Integer quantidade;
    private Double valor_unitario;
    private Produto produto;  //(chave estrangeira para a tabela de blusas)
    private Pedido pedido; //
}
