package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Dieta;

import java.util.List;

@Repository
public interface IDietaRepository extends JpaRepository<Dieta, Integer> {
    @Query(value = "SELECT id_usuario, COUNT(*) AS cantidad_dietas \n" +
            "FROM Dieta \n" +
            "GROUP BY id_usuario \n" +
            "ORDER BY cantidad_dietas DESC;", nativeQuery = true)
    public List<String[]> cantidadDietas();

    @Query(value = "SELECT id_usuario, SUM(duracion) AS duracion_total_usuario \n" +
            "FROM Dieta \n" +
            "GROUP BY id_usuario \n" +
            "ORDER BY duracion_total_usuario DESC;", nativeQuery = true)
    public List<String[]> duraciontotaldietas();
}


