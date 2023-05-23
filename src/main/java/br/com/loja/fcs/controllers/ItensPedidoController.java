package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.entity.dto.ItensPedidoDTO;
import br.com.loja.fcs.domain.entity.ItemPedido;
import br.com.loja.fcs.services.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItensPedidoController {

    @Autowired
    ItensPedidoService itensPedidoService;

    @GetMapping("/")
    @RolesAllowed("ADMIN") // Autorização requerida: apenas usuários com a role 'ROLE_ADMIN' podem acessar este endpoint
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
