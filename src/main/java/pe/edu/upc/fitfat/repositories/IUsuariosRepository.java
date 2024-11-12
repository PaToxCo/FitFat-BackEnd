package pe.edu.upc.fitfat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.fitfat.dtos.UsuariosPorRolDTO;
import pe.edu.upc.fitfat.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {
    @Query("select u from Usuarios u where u.correo like %:correo%")
    public List<Usuarios> buscarxcorreo(@Param("correo") String correo);
    //query control
    @Query("select u from Usuarios u where u.nombre = :nombre")
    Usuarios findByNombre(@Param("nombre") String nombre);
    @Query("select u from Usuarios u where u.usuario = :usuario")
    Usuarios findOneByUsuario(@Param("usuario") String usuario);
    @Query("SELECT " +
            "CASE WHEN u.enabled = true THEN 'Activo' ELSE 'Inactivo' END AS estado_usuario, " +
            "COUNT(u) AS cantidad " +
            "FROM Usuarios u " +
            "GROUP BY u.enabled")
    List<String[]> contarUsuariosActivosInactivos();
    @Query("SELECT new pe.edu.upc.fitfat.dtos.UsuariosPorRolDTO(r.descripcion, COUNT(u)) " +
            "FROM Usuarios u " +
            "JOIN u.roles r " +
            "GROUP BY r.descripcion")
    List<UsuariosPorRolDTO> contarUsuariosPorRol();
    }

