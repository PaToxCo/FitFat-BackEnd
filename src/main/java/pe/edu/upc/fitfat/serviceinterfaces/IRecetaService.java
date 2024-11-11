package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Receta;

import java.util.List;

public interface IRecetaService {

    List<Receta> list();
    void insert(Receta receta);
    Receta listId(int id);
    void update(Receta receta);
    void delete(int id);
    List<Receta> searchRecetasByNombreAndUsuario(String nombre, int idUsuario);
}
