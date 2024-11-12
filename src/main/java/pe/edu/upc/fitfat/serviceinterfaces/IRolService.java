package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Rol;
import java.util.List;

public interface IRolService {
    public List<Rol> list();

    public void insert(Rol r);

    public Rol listId(int id);

    public void update(Rol r);

    public void delete(int id);

}
