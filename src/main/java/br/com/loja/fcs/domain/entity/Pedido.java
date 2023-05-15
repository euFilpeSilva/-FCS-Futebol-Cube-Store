package br.com.loja.fcs.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_pedido")
    private LocalDate data_pedido;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> ip;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
}
