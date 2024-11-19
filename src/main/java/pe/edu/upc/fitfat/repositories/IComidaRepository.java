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
    @Query(value = "SELECT u.nombre, SUM(c.calorias) " +
            "FROM Comida c INNER JOIN Usuarios u ON c.id_usuario = u.id_usuario " +
            "GROUP BY u.nombre", nativeQuery = true)
    public List<String[]> sumaCaloriasPorUsuario();
//    cuántas comidas de un tipo determinado han sido marcadas como favoritas
    @Query(value = "SELECT t.tipo, COUNT(c.comi_favo) " +
            "FROM Comida c INNER JOIN Tipo_comida t ON c.id_tip_comi = t.id_tip_comi " +
            "WHERE c.comi_favo = true " +
            "GROUP BY t.tipo", nativeQuery = true)
    public List<String[]> cantidadComidasFavoritasPorTipo();
}
