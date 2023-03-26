package br.com.loja.virtual.usuarios.domain.repository;

import br.com.loja.virtual.usuarios.domain.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

   public List<Usuarios> findAllByOrderByIdAsc();

//   @Query(value="SELECT u.* FROM usuarios u JOIN time t ON u.time_id = t.id", nativeQuery = true)
//   List<Usuarios> findAllWithTime();
}
