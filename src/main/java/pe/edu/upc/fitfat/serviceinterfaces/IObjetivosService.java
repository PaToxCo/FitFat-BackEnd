package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Objetivos;


import java.util.List;

public interface IObjetivosService {
    public List<Objetivos> list();
    public void insert(Objetivos obj);
    public Objetivos listId(int id);
    public void update(Objetivos obj);
    public void delete(int id);
    List<Objetivos> buscarPorEstado(String estado);
    List<Objetivos> buscarPorTipoObjetivo (String objetivo);
}
