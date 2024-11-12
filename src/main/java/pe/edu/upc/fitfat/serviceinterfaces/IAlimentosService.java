package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Alimentos;
import java.util.List;

public interface IAlimentosService {

    List<Alimentos> list();
    void insert(Alimentos alimento);
    Alimentos listId(int id);
    void update(Alimentos alimento);
    void delete(int id);
    List<Alimentos> filtrarPorUsuarioId(int usuarioId);
    List<Alimentos> findAlimentosByNombreAndUsuario(String nombre, int idUsuario);

}
