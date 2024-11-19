package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.dtos.ControlesPorDietaDTO;
import pe.edu.upc.fitfat.dtos.ControlesPorGeneroDTO;
import pe.edu.upc.fitfat.entities.Control;

import java.sql.Date;
import java.util.List;

@Repository
public interface IControlRepository extends JpaRepository<Control, Integer> {

    @Query("select c from Control c where c.fecha = :fecha")
    List<Control> filtrarPorFecha(@Param("fecha") Date fecha);

    @Query("select c from Control c where c.usuario.idUsuario = :usuarioId order by c.idControl desc")
    List<Control> findByUsuarioIdOrderByIdControlDesc(@Param("usuarioId") int usuarioId);
    @Query(value = "SELECT d.id_dieta, COUNT(c) FROM Control c JOIN Dieta d ON c.dieta_id_dieta = d.id_dieta GROUP BY d.id_dieta", nativeQuery = true)
    List<String[]> getControlesPorDieta();

    @Query(value = "SELECT c.genero, COUNT(c) FROM Control c GROUP BY c.genero", nativeQuery = true)
    List<String[]> getControlesPorGenero();

}
