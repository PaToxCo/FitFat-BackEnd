package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Receta;
import pe.edu.upc.fitfat.repositories.IRecetaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IRecetaService;
//para insertar receta sin necesidad d poner usuario id
import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.repositories.IComidaRepository;

import java.util.List;

@Service
public class RecetaServiceImplement implements IRecetaService {

    @Autowired
    private IRecetaRepository rR;
    @Autowired
    private IComidaRepository cR;

    @Override
    public List<Receta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Receta receta) {
        // Obtener el idComida de la comida asociada
        Comida comida = receta.getComida();
        if (comida != null) {
            Integer comidaId = comida.getIdComida();
            Comida comidaFromDB = cR.findById(comidaId).orElse(null);

            if (comidaFromDB != null) {
                // Asignar la comida recuperada a la receta
                receta.setComida(comidaFromDB);
            } else {
                throw new RuntimeException("Comida no encontrada");
            }
        } else {
            throw new RuntimeException("Comida no proporcionada en la receta");
        }

        rR.save(receta);
    }
    @Override
    public Receta listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Receta receta) {
        rR.save(receta);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<Receta> searchRecetasByNombreAndUsuario(String nombre, int idUsuario) {
        return rR.findRecetasByNombreAndUsuario(nombre, idUsuario);
    }
}
