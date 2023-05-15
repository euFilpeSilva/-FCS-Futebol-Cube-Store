package br.com.loja.fcs.domain.entity;

import br.com.loja.fcs.domain.ennum.TamanhoBlusa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="preco")
    private Double preco;

    @Enumerated(EnumType.STRING)
    private TamanhoBlusa tamanho;

    @Column(name="imagem")
    private String imagem;

    @Column(name="estoque")
    private Integer estoque;

    //Cada time tem varias blusas e cada blusa contem um só time
    @ManyToOne
    @JoinColumn(name = "time")
    private Time time;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> ip;


}
