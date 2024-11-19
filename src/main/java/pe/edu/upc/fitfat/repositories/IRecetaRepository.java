package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Receta;

import java.util.List;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Integer> {

    @Query("SELECT r FROM Receta r WHERE r.nombre LIKE %:nombre% AND r.comida.idComida IN (SELECT c.idComida FROM Comida c WHERE c.usuario.idUsuario = :idUsuario)")
    List<Receta> findRecetasByNombreAndUsuario(@Param("nombre") String nombre, @Param("idUsuario") int idUsuario);
    @Query("SELECT r.comida.idComida AS comidaId, COUNT(r) AS totalRecetas FROM Receta r GROUP BY r.comida.idComida")
    List<String[]> countRecetasByComida();

    @Query("SELECT r.comida.idComida AS comidaId, SUM(LENGTH(r.descripcion)) AS totalDescripcionLength FROM Receta r GROUP BY r.comida.idComida")
    List<String[]> sumDescripcionLengthByComida();

}

