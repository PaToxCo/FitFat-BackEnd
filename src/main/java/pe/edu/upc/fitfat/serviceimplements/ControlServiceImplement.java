package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Control;
import pe.edu.upc.fitfat.repositories.IControlRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IControlService;
//USUARIO
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.repositories.IUsuariosRepository;

import java.sql.Date;
import java.util.List;

@Service
public class ControlServiceImplement implements IControlService {

    @Autowired
    private IControlRepository cR;

    @Override
    public List<Control> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Control c) {
        cR.save(c);
    }

    @Override
    public Control listId(int id) {
        return cR.findById(id).orElse(new Control());
    }

    @Override
    public void update(Control c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Control> filtrarPorFecha(Date fecha) {
        return cR.filtrarPorFecha(fecha);
    }

    @Override
    public Control obtenerUltimoControlPorNombreUsuario(String nombre) {
        Usuarios usuario = uR.findByNombre(nombre);
        if (usuario != null) {
            List<Control> controles = cR.findByUsuarioIdOrderByIdControlDesc(usuario.getIdUsuario());
            return controles.isEmpty() ? new Control() : controles.get(0);
        }
        return new Control();
    }
    @Autowired
    private IUsuariosRepository uR;
}
