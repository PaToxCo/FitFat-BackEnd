package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.fitfat.entities.Receta;
import pe.edu.upc.fitfat.entities.Respuesta;

import java.util.List;

public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer> {
    @Query(value = "SELECT r.* FROM respuesta r WHERE r.fecha_respuesta >= NOW() - INTERVAL '7 days'", nativeQuery = true)
    List<Respuesta> Buscarporfecha();
    @Query(value = "SELECT r.*, c.* FROM respuesta r JOIN consulta c ON r.consulta_id = c.id WHERE r.asunto = 'Asunto Específico'", nativeQuery = true)
    List<Respuesta> BuscarporAsunto(String asunto);
}