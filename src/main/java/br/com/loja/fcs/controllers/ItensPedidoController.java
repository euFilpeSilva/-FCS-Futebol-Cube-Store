package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.dto.ItensPedidoDTO;
import br.com.loja.fcs.domain.entity.ItemPedido;
import br.com.loja.fcs.services.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItensPedidoController {

    @Autowired
    ItensPedidoService itensPedidoService;

    @GetMapping("/")
    public ResponseEntity<List<ItensPedidoDTO>> getItensPedido() {
        return new ResponseEntity<>(itensPedidoService.getListaItensPedido(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensPedidoDTO> getItensPedidoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(itensPedidoService.getItensPedidoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensPedidoDTO> editarItensPedido(@RequestBody ItemPedido itensPedido, @PathVariable Long id) {
        return new ResponseEntity<>(itensPedidoService.editarItensPedido(itensPedido, id), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody ItensPedidoDTO itensPedido) {
        return new ResponseEntity<>(itensPedidoService.cadastrar(itensPedido), HttpStatus.CREATED);
    }

}
