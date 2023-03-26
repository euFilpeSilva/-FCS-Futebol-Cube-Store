package br.com.loja.virtual.blusa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlusaDTO implements Serializable {

    private Long id;

    private String nome;

    private Double preco;

    private String tamanho;

    private String imagem;

//Cada time tem varias blusas e cada blusa contem um só time
    private Long timeId;
}
