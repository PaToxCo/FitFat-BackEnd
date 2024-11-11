package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Objetivos;
import pe.edu.upc.fitfat.repositories.IObjetivosRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IObjetivosService;

import java.util.List;

@Service
public class ObjetivosServiceImplement implements IObjetivosService {
    @Autowired
    private IObjetivosRepository oR;

    @Override
    public List<Objetivos> list() {
        return oR.findAll();
    }

    @Override
    public void insert(Objetivos obj) {
        oR.save(obj);
    }

    @Override
    public Objetivos listId(int id) {
        return oR.findById(id).orElse(new Objetivos());
    }

    @Override
    public void update(Objetivos obj) {
        oR.save(obj);
    }

    @Override
    public void delete(int id) {
        oR.deleteById(id);
    }

    @Override
    public List<Objetivos> buscarPorEstado(String estado) {
        return oR.buscarPorEstado(estado);
    }

    @Override
    public List<Objetivos> buscarPorTipoObjetivo(String objetivo) {
        return oR.buscarPorTipoObjetivo(objetivo);
    }


}
