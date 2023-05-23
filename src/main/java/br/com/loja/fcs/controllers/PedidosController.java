package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.entity.dto.PedidoDTO;
import br.com.loja.fcs.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/")
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        return new ResponseEntity<>(pedidosService.listarPedidos(), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public String salvarPedido(@RequestBody PedidoDTO pedido) {
        return pedidosService.salvarPedido(pedido);
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPedido(@PathVariable Long id) {
        return pedidosService.buscarPedido(id);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedido) {
        return pedidosService.atualizarPedido(pedido);
    }

//    @DeleteMapping("/{id}")
//    public void deletarPedido(@PathVariable Long id) {
//        pedidosService.deletarPedido(id);
//    }

}

