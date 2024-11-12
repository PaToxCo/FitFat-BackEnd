package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Rol;
import pe.edu.upc.fitfat.repositories.IRolRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol r) {
        rR.save(r);
    }

    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(new Rol());
    }

    @Override
    public void update(Rol r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
}