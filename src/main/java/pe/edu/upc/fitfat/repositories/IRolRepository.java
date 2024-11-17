package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.entities.Respuesta;
import pe.edu.upc.fitfat.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT r.descripcion,  u.id_usuario\n" +
            "FROM Rol r\n" +
            "JOIN Usuarios u ON r.id_usuario = u.id_usuario\n" +
            "WHERE u.enabled = 'true';", nativeQuery = true)
    public List<String[]> listarolesactivos();
}
