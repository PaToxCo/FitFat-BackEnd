package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Consulta;
import pe.edu.upc.fitfat.repositories.IConsultaRepository;
import pe.edu.upc.fitfat.serviceinterfaces.IConsultaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultaServiceImplements implements IConsultaService {
    @Autowired
    private IConsultaRepository conR;

    @Override
    public void insert(Consulta c) {
        conR.save(c);
    }

    @Override
    public List<Consulta> list() {
        return conR.findAll();
    }

    @Override
    public Consulta listId(int id) {
        return conR.findById(id).orElse(new Consulta());
    }

    @Override
    public void update(Consulta c) {
        conR.save(c);
    }

    @Override
    public void delete(int id) {
        conR.deleteById(id);
    }

    @Override
    public List<Consulta> buscarFechaConsulta(LocalDate fechaConsulta) {
        return conR.buscarFechaConsulta(fechaConsulta);
    }

    @Override
    public List<Consulta> buscarAsunto(String asunto) {
        return List.of();
    }
}

