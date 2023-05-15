package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   public List<Usuario> findAllByOrderByIdAsc();

   public Optional<Usuario> findByUsername(String username);

//   @Query(value="SELECT u.* FROM usuarios u JOIN time t ON u.time_id = t.id", nativeQuery = true)
//   List<Usuarios> findAllWithTime();
}
