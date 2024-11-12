package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Dieta;
import java.util.List;

public interface IDietaService {
    List<Dieta> list();
    void insert(Dieta d);
    Dieta listId(int idDieta);
    void update(Dieta d);
    void delete(int idDieta);
    List<Dieta> buscardietapornombre(String nombre);
}
