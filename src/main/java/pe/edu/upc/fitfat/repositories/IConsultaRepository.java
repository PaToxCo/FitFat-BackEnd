package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Consulta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {
    @Query("SELECT c FROM Consulta c WHERE c.fechaConsulta = :fechaC")
    public List<Consulta> buscarFechaConsulta(@Param("fechaC") LocalDate fecha);
}
