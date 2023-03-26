package br.com.loja.virtual.blusa.services;

import br.com.loja.virtual.blusa.domain.dto.BlusaDTO;
import br.com.loja.virtual.blusa.domain.entity.Blusa;
import br.com.loja.virtual.blusa.domain.repository.BlusaRepository;
import br.com.loja.virtual.blusa.services.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlusaService {

    @Autowired
    private BlusaRepository blusaRepository;

    @Autowired
    private Converter c;

    public BlusaService() {
    }

    public List<BlusaDTO> listarBlusas() {
        List<Blusa> blusas = blusaRepository.findAllWithTime();
        return blusas.stream()
                .map(blusa -> Converter.converter(blusa, BlusaDTO.class))
                .collect(Collectors.toList());
    }

    public BlusaDTO buscarBlusaPorId(Long id) {
        Blusa blusa = blusaRepository.findById(id).get();
        return Converter.converter(blusa, BlusaDTO.class);
    }

    public String criarBlusa(BlusaDTO blusaDTO) {
        try {
            Blusa blusa = Converter.converter(blusaDTO, Blusa.class);
            blusaRepository.save(blusa);
            return "Blusa criada com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar blusa: " + e.getMessage();
        }
   }

    public BlusaDTO editarBlusa(BlusaDTO blusaDTO, Long id) {
        Blusa blusa = Converter.converter(blusaDTO, Blusa.class);
        blusa.setId(id);
        blusaRepository.save(blusa);
        return Converter.converter(blusa, BlusaDTO.class);
    }
}
