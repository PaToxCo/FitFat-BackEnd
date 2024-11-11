package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Alimentos;
import pe.edu.upc.fitfat.repositories.IAlimentosRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IAlimentosService;

import java.util.List;

@Service
public class AlimentosServiceImplement implements IAlimentosService {

    @Autowired
    private IAlimentosRepository alimentosRepository;

    @Override
    public List<Alimentos> list() {
        return alimentosRepository.findAll();
    }

    @Override
    public void insert(Alimentos alimento) {
        alimentosRepository.save(alimento);
    }

    @Override
    public Alimentos listId(int id) {
        return alimentosRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Alimentos alimento) {
        alimentosRepository.save(alimento);
    }

    @Override
    public void delete(int id) {
        alimentosRepository.deleteById(id);
    }

    @Override
    public List<Alimentos> filtrarPorUsuarioId(int usuarioId) {
        return alimentosRepository.findByUsuarioId(usuarioId);
    }
    @Override
    public List<Alimentos> findAlimentosByNombreAndUsuario(String nombre, int idUsuario) {
        return alimentosRepository.findAlimentosByNombreAndUsuario(nombre, idUsuario);
    }
}
