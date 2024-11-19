package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Objetivos;

import java.util.List;

public interface IObjetivosService {
    List<Objetivos> list();
    void insert(Objetivos obj);
    Objetivos listId(int id);
    void update(Objetivos obj);
    void delete(int id);
    List<Objetivos> buscarPorEstado(String estado);
    List<Objetivos> buscarPorTipoObjetivo(String objetivo);
    List<String[]> obtenerFechasPorEstado();
    List<String[]> obtenerDuracionPorTipoObjetivo();
}
