package br.com.loja.virtual.blusa.domain.dto;

//import br.com.loja.virtual.blusa.domain.dto.BlusaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeDTO implements Serializable {

    private Long id;

    private String nome;

    private String escudo;

//    private List<BlusaDTO> blusa;
}
