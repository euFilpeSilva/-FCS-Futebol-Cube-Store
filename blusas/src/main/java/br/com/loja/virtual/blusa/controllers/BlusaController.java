package br.com.loja.virtual.blusa.controllers;

import br.com.loja.virtual.blusa.domain.dto.BlusaDTO;
import br.com.loja.virtual.blusa.services.BlusaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blusas")
public class BlusaController {

    @Autowired
    private BlusaService blusaService;

    @GetMapping
    public ResponseEntity<List<BlusaDTO>> listarBlusas() {
        return new ResponseEntity<>(blusaService.listarBlusas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlusaDTO> buscarBlusaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(blusaService.buscarBlusaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> criarBlusa(@RequestBody BlusaDTO blusaDTO) {
        return new ResponseEntity<>(blusaService.criarBlusa(blusaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlusaDTO> editarBlusa(@RequestBody BlusaDTO blusaDTO, @PathVariable Long id) {
        return new ResponseEntity<>(blusaService.editarBlusa(blusaDTO, id), HttpStatus.OK);
    }
}
