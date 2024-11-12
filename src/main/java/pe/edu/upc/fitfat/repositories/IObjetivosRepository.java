package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Objetivos;

import java.util.List;

@Repository
public interface IObjetivosRepository extends JpaRepository<Objetivos, Integer>{
    @Query("select o from Objetivos o where o.estado = :estado")
    public List<Objetivos> buscarPorEstado(@Param("estado") String estado);
    @Query("select o from Objetivos o where o.tipo_objetivo = :tipo_objetivo")
    public List<Objetivos> buscarPorTipoObjetivo(@Param("tipo_objetivo") String tipoObjetivo);
}
