package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

   public List<Produto> findAllByOrderByIdAsc();

   @Query(value="SELECT p.* FROM produto p JOIN time t ON p.time_id = t.id", nativeQuery = true)
   List<Produto> findAllWithTime();
}
