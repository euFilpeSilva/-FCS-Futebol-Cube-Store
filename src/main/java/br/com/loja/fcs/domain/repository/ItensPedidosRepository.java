package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItensPedidosRepository extends JpaRepository<ItemPedido, Long> {

    List<ItensPedidosRepository> findAllByOrderByIdAsc();
}
