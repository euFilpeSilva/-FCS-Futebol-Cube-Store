package br.com.loja.virtual.blusa.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@EqualsAndHashCode
@Getter
@Setter // Cria os getters e setters da nossa classe
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blusa")
public class Blusa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="preco")
    private Double preco;

    @Column(name="tamanho")
    private String tamanho;

    @Column(name="imagem")
    private String imagem;

    //Cada time tem varias blusas e cada blusa contem um só time
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

}
