package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Tipo_comida;
import pe.edu.upc.fitfat.repositories.ITipo_comidaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.ITipo_comidaService;

import java.util.List;

@Service
public class Tipo_comidaServiceImplement implements ITipo_comidaService {
    @Autowired
    private ITipo_comidaRepository tR;

    @Override
    public List<Tipo_comida> list() {
        return tR.findAll();
    }

    @Override
    public void insert(Tipo_comida tc) {
        tR.save(tc);
    }

    @Override
    public Tipo_comida listId(int id) {
        return tR.findById(id).orElse(new Tipo_comida());
    }

    @Override
    public void update(Tipo_comida tc) {
        tR.save(tc);
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }
    @Override
    public List<Object[]> findMostFrequentTipoComidaByUsuarioId(int usuarioId) {
        return tR.findMostFrequentTipoComidaByUsuarioId(usuarioId);
    }
    @Override
    public List<Tipo_comida> filterByCategory(String categoria) {
        return tR.findByCategoria(categoria);
    }
}
