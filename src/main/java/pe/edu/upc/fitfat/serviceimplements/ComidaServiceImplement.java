package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.repositories.IComidaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IComidaService;
//tipo comida
import pe.edu.upc.fitfat.repositories.ITipo_comidaRepository;

import java.util.List;

@Service
public class ComidaServiceImplement implements IComidaService {

    @Autowired
    private IComidaRepository cR;

    @Autowired
    private ITipo_comidaRepository tipoComidaRepository;
    @Override
    public List<Comida> list() {
        return cR.findAll();
    }

    @Override
    public Comida insert(Comida c) {
        return cR.save(c);
    }

    @Override
    public Comida listId(int id) {
        return cR.findById(id).orElse(new Comida());
    }

    @Override
    public void update(Comida c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Comida> findFavoriteComidas(int idUsuario) {
        return cR.findByComiFavoTrueAndUsuarioIdUsuario(idUsuario);
    }

    @Override
    public Comida findComidaWithMostCalories(int idUsuario) {
        List<Comida> comidas = cR.findComidasOrderByCaloriasDescByUsuario(idUsuario);
        return comidas.isEmpty() ? null : comidas.get(0);
    }

    @Override
    public List<Comida> searchComidaByName(String nombre) {
        return cR.findByNombreContainingIgnoreCase(nombre);
    }
}
