package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Comida;
import java.util.List;

public interface IComidaService {
    List<Comida> list();
    Comida insert(Comida c);
    Comida listId(int id);
    void update(Comida c);
    void delete(int id);
    List<Comida> findFavoriteComidas(int idUsuario);
    Comida findComidaWithMostCalories(int idUsuario);
    List<Comida> searchComidaByName(String nombre);
}
