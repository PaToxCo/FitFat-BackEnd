package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Usuarios;
import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public void insert(Usuarios u);
    public Usuarios listId(int id);
    public void update(Usuarios u);
    public void delete(int id);
    public List<Usuarios> buscarxcorreo(String correo);
    public Usuarios findOneByUsuario(String usuario);

}
