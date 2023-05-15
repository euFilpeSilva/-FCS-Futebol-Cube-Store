package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesRepository extends JpaRepository<Time, Long> {

    List<Time> findAllByOrderByIdAsc();

}
