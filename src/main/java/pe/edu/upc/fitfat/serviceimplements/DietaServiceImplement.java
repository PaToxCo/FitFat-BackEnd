package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Dieta;
import pe.edu.upc.fitfat.repositories.IDietaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IDietaService;

import java.util.List;

@Service
public class DietaServiceImplement implements IDietaService {

    @Autowired
    private IDietaRepository dR;

    @Override
    public List<Dieta> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Dieta d) {
        dR.save(d);
    }

    @Override
    public Dieta listId(int id) {
        return dR.findById(id).orElse(new Dieta());
    }

    @Override
    public void update(Dieta d) {
        dR.save(d);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public List<Dieta> buscardietapornombre(String nombre) {
        return dR.buscarxnombre(nombre);
    }

}
