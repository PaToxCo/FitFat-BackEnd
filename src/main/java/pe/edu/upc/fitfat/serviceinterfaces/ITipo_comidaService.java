package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Tipo_comida;
import java.util.List;

public interface ITipo_comidaService {

    public List<Tipo_comida> list();
    public void insert(Tipo_comida tc);
    public Tipo_comida listId(int id);
    public void update(Tipo_comida tc);
    public void delete(int id);
    public List<Object[]> findMostFrequentTipoComidaByUsuarioId(int usuarioId);
    public List<Tipo_comida> filterByCategory(String category);
}
