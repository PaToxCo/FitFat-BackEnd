package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Control;

import java.sql.Date;
import java.util.List;

@Repository
public interface IControlRepository extends JpaRepository<Control, Integer> {

    @Query("select c from Control c where c.fecha = :fecha")
    List<Control> filtrarPorFecha(@Param("fecha") Date fecha);

    @Query("select c from Control c where c.usuario.idUsuario = :usuarioId order by c.idControl desc")
    List<Control> findByUsuarioIdOrderByIdControlDesc(@Param("usuarioId") int usuarioId);

}
