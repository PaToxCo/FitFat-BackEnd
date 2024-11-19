package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.entities.Consulta;

import java.time.LocalDate;
import java.util.List;

public interface IConsultaService {
    public void insert(Consulta c);
    public List<Consulta> list();
    public Consulta listId(int id);
    public void update(Consulta c);
    public void delete(int id);
    public List<Consulta> buscarFechaConsulta(LocalDate fechaConsulta);
    public List<Consulta> buscarAsunto(String asunto);
}
