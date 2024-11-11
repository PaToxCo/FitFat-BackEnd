package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Comida;

import java.util.List;

@Repository
public interface IComidaRepository extends JpaRepository<Comida, Integer> {

    @Query("SELECT c FROM Comida c WHERE c.comiFavo = true AND c.usuario.idUsuario = :idUsuario")
    List<Comida> findByComiFavoTrueAndUsuarioIdUsuario(@Param("idUsuario") int usuarioId);
    @Query("SELECT c FROM Comida c WHERE c.usuario.idUsuario = :idUsuario ORDER BY c.calorias DESC")
    List<Comida> findComidasOrderByCaloriasDescByUsuario(@Param("idUsuario") int usuarioId);
    List<Comida> findByNombreContainingIgnoreCase(String nombre);
}
