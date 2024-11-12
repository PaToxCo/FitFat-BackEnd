package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Alimentos;

import java.util.List;

@Repository
public interface IAlimentosRepository extends JpaRepository<Alimentos, Integer> {

    @Query("SELECT a FROM Alimentos a JOIN a.receta r JOIN r.comida c WHERE c.usuario.id = ?1")
    List<Alimentos> findByUsuarioId(int usuarioId);
    @Query("SELECT a FROM Alimentos a WHERE a.nombre LIKE %:nombre% AND a.receta.idReceta IN (SELECT r.idReceta FROM Receta r JOIN r.comida c WHERE c.usuario.id = :idUsuario)")
    List<Alimentos> findAlimentosByNombreAndUsuario(@Param("nombre") String nombre, @Param("idUsuario") int idUsuario);
    @Query(value = "SELECT dieta.nombre AS dieta, COUNT(a.id_alimentos) AS totalAlimentos " +
            "FROM Alimentos a " +
            "JOIN Dieta dieta ON a.dieta_id_dieta = dieta.id_dieta " +
            "GROUP BY dieta.nombre", nativeQuery = true)
    List<String[]> countAlimentosByDieta();

    @Query(value = "SELECT dieta.nombre AS dieta, SUM(a.calorias) AS totalCalorias " +
            "FROM Alimentos a " +
            "JOIN Dieta dieta ON a.dieta_id_dieta = dieta.id_dieta " +
            "GROUP BY dieta.nombre", nativeQuery = true)
    List<String[]> sumCaloriasByDieta();
}
