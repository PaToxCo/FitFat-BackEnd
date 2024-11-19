package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Respuesta;
import pe.edu.upc.fitfat.repositories.IRespuestaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IRespuestaService;

import java.util.List;
@Service
public class RespuestaServiceImplement implements IRespuestaService {
    @Autowired
    private IRespuestaRepository rR;

    @Override
    public List<Respuesta> list() {
        return rR.findAll();
    }

    @Override
    public Respuesta insert(Respuesta r) {
        return rR.save(r);
    }

    @Override
    public Respuesta listId(int id) {
        return rR.findById(id).orElse(new Respuesta());
    }

    @Override
    public Respuesta update(Respuesta r) {
        return rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<Respuesta> BuscarporAsunto(String asunto) {
        return rR.BuscarporAsunto(asunto);
    }

    @Override
    public List<Respuesta> Buscarporfecha() {
        return rR.Buscarporfecha();
    }
}