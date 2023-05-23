package br.com.loja.fcs.services;

import br.com.loja.fcs.converter.Converter;
import br.com.loja.fcs.domain.entity.dto.PedidoDTO;
import br.com.loja.fcs.domain.entity.Pedido;
import br.com.loja.fcs.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    Converter converter;

    public List<PedidoDTO> listarPedidos() {
        List<Pedido> p = pedidosRepository.findAllByOrderByIdAsc();
        return p.stream()
                .map(pedido -> converter.converter(pedido, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    public String salvarPedido(PedidoDTO pedido) {
        Pedido p = converter.converter(pedido, Pedido.class);
        Pedido pedidoSalvo = pedidosRepository.save(p);
        if (pedidoSalvo.getId() != null) {
            return "Pedido cadastrado com sucesso!";
        }
        return "Falha ao cadastrar pedido!";
    }

    public PedidoDTO buscarPedido(Long id) {
       Pedido p = pedidosRepository.findById(id).get();
        return converter.converter(p, PedidoDTO.class);
    }

    public PedidoDTO atualizarPedido(PedidoDTO pedido) {
        Pedido p = converter.converter(pedido, Pedido.class);
        Pedido pedidoAtualizado = pedidosRepository.save(p);
        return converter.converter(pedidoAtualizado, PedidoDTO.class);
    }

//    public void deletarPedido(Long id) {
//        pedidosRepository.deleteById(id);
//    }
}
