package br.com.lojaVirtual.fcs.futebolClubeStore.modules.blusas.domain.entity;

import java.sql.Time;
import java.util.List;

public class Blusa implements BlusaImpl {

    private Long id;

    private String nome;

    private String tamanho;

    private Double preco;

    private String imagem;

    private List<Time> times;
}
