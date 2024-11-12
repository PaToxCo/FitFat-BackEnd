package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Tipo_comida;

import java.util.List;

@Repository
public interface ITipo_comidaRepository extends JpaRepository<Tipo_comida, Integer> {
    @Query("SELECT tc.tipo, tc.categoria, COUNT(c) AS frecuencia " +
            "FROM Comida c " +
            "JOIN c.tipoComida tc " +
            "WHERE c.usuario.idUsuario = :usuarioId " +
            "GROUP BY tc.tipo, tc.categoria " +
            "ORDER BY frecuencia DESC")
    List<Object[]> findMostFrequentTipoComidaByUsuarioId(@Param("usuarioId") int usuarioId);
    List<Tipo_comida> findByCategoria(String categoria);
}
