package br.com.loja.virtual.blusa.domain.repository;

import br.com.loja.virtual.blusa.domain.entity.Blusa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlusaRepository extends JpaRepository<Blusa, Long> {

   public List<Blusa> findAllByOrderByIdAsc();

   @Query(value="SELECT b.* FROM blusa b JOIN time t ON b.time_id = t.id", nativeQuery = true)
   List<Blusa> findAllWithTime();
}
