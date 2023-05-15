package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends CrudRepository<Pedido, Long> {
    List<Pedido> findAllByOrderByIdAsc();
}

