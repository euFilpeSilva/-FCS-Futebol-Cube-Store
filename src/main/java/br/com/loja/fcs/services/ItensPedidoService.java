package br.com.loja.fcs.services;

import br.com.loja.fcs.converter.Converter;
import br.com.loja.fcs.domain.dto.ItensPedidoDTO;
import br.com.loja.fcs.domain.entity.ItemPedido;
import br.com.loja.fcs.domain.entity.Produto;
import br.com.loja.fcs.domain.repository.ItensPedidosRepository;
import br.com.loja.fcs.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItensPedidoService {

    @Autowired
    ItensPedidosRepository itensPedidoRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    Converter c;

    public String cadastrar(ItensPedidoDTO itensPedido) {
        try {
            Produto produto = produtoRepository.findById(itensPedido.getProduto().getId()).orElse(null);
            if (produto == null || produto.getEstoque() == null || produto.getEstoque() < itensPedido.getQuantidade()) {
                return "Não é possível criar um novo itemPedido para um produto sem estoque disponível.";
            }

            ItemPedido itensPedidoEntity = Converter.converter(itensPedido, ItemPedido.class);
            itensPedidoRepository.save(itensPedidoEntity);

            // Atualiza o estoque do produto
            produto.setEstoque(produto.getEstoque() - itensPedido.getQuantidade());
            produtoRepository.save(produto);

            return "ItensPedido criado com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar ItensPedido: " + e.getMessage();
        }
    }

    public ItensPedidoDTO editarItensPedido(ItemPedido itensPedido, Long id) {
        itensPedido.setId(id);
        itensPedidoRepository.save(itensPedido);
        return c.converter(itensPedido, ItensPedidoDTO.class);
    }


    public ItensPedidoDTO getItensPedidoPorId(Long id) {
        ItemPedido itensPedido = itensPedidoRepository.findById(id).get();
        return c.converter(itensPedido, ItensPedidoDTO.class);
    }

    public List<ItensPedidoDTO> getListaItensPedido() {
        List<ItemPedido> ip = itensPedidoRepository.findAll();
        return ip.stream()
                .map(itensPedido -> c.converter(itensPedido, ItensPedidoDTO.class))
                .collect(Collectors.toList());
    }

//    public void deleteItensPedido(Long id) {
//        itensPedidoRepository.deleteById(id);
//    }
}
