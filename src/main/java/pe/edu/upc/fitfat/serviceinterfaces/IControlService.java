package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Control;
import java.sql.Date;
import java.util.List;

public interface IControlService {
    List<Control> list();
    void insert(Control c);
    Control listId(int id);
    void update(Control c);
    void delete(int id);
    List<Control> filtrarPorFecha(Date fecha);
    Control obtenerUltimoControlPorNombreUsuario(String nombre);
}
