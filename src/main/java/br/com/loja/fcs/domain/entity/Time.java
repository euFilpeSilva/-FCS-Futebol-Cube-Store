package br.com.loja.fcs.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@EqualsAndHashCode
@Getter
@Setter // Cria os getters e setters da nossa classe
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="time")
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="imagem")
    private String escudo;

//Cada time tem varias blusas e cada blusa contem um só time
    @JsonIgnore
    @OneToMany(mappedBy = "time")
    private List<Produto> produtos;


}
