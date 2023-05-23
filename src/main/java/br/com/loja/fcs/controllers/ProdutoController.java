package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.entity.dto.ProdutoDTO;
import br.com.loja.fcs.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Api(tags = "Produtos API", description = "Endpoints para gerenciamento de produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PreAuthorize("hasRole('ADMIN','USER')")
    @GetMapping
    @ApiOperation(value = "Lista de produtos")
    public ResponseEntity<List<ProdutoDTO>> listarP() {
        return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.buscarBlusaPorId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN','USER')")
    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.criarBlusa(produtoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> editarBlusa(@RequestBody ProdutoDTO produtoDTO, @PathVariable Long id) {
        return new ResponseEntity<>(produtoService.editarBlusa(produtoDTO, id), HttpStatus.OK);
    }
}

