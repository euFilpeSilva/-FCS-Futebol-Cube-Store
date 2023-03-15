package br.com.lojaVirtual.fcs.futebolClubeStore.blusa.src.main.java.br.com.lojaVirtual.fcs.futebolClubeStore.blusa.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blusa")
public class Blusa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String tamanho;

    @Column
    private Double preco;

    @Column
    private String imagem;

    @OneToMany(mappedBy = "blusa")
    private List<Time> times;

}
