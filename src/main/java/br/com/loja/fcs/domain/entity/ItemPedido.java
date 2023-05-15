package br.com.loja.fcs.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id; //(chave primária)

    @Column
    private Integer quantidade;

    @Column
    private Double valor_unitario;

    @ManyToOne
    @JoinColumn(name = "produto")
    private Produto produto;  //(chave estrangeira para a tabela de blusas)

    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido; //(chave estrangeira para a tabela de pedidos)

}
