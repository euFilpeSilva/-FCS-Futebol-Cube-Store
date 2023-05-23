package br.com.loja.fcs.domain.entity.dto;

import br.com.loja.fcs.domain.entity.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private Double preco;

    private String tamanho;

    private String imagem;

    private Integer estoque;

    private Time time;

//Cada time tem varias blusas e cada blusa contem um só time

}
