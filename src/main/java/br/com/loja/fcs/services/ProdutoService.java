package br.com.loja.fcs.services;

import br.com.loja.fcs.converter.Converter;
import br.com.loja.fcs.domain.entity.dto.ProdutoDTO;
import br.com.loja.fcs.domain.entity.Produto;
import br.com.loja.fcs.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Converter c;

    public ProdutoService() {
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAllByOrderByIdAsc();
        return produtos.stream()
                .map(produto -> Converter.converter(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarBlusaPorId(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        return Converter.converter(produto, ProdutoDTO.class);
    }

    public String criarBlusa(ProdutoDTO produtoDTO) {
        try {
            Produto produto = Converter.converter(produtoDTO, Produto.class);
            produtoRepository.save(produto);
            return "Blusa criada com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar blusa: " + e.getMessage();
        }
   }

    public ProdutoDTO editarBlusa(ProdutoDTO produtoDTO, Long id) {
        Produto produto = Converter.converter(produtoDTO, Produto.class);
        produto.setId(id);
        produtoRepository.save(produto);
        return Converter.converter(produto, ProdutoDTO.class);
    }
}
