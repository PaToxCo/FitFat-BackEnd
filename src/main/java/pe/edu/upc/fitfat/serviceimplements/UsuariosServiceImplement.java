package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.repositories.IUsuariosRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IUsuariosService;

import java.util.List;

@Service
public class UsuariosServiceImplement implements IUsuariosService {
    @Autowired
    private IUsuariosRepository uR;

    @Override
    public List<Usuarios> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuarios u) {
        uR.save(u);
    }

    @Override
    public Usuarios listId(int id) {
        return uR.findById(id).orElse(new Usuarios());
    }

    @Override
    public void update(Usuarios u) {
        uR.save(u);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<Usuarios> buscarxcorreo(String correo) {
        return uR.buscarxcorreo(correo);
    }

    @Override
    public Usuarios findOneByUsuario(String usuario) {
        return uR.findOneByUsuario(usuario);
    }
}
