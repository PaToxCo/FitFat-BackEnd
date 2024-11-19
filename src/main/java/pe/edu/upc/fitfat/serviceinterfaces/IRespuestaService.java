package pe.edu.upc.fitfat.serviceinterfaces;

import pe.edu.upc.fitfat.entities.Respuesta;

import java.util.List;

public interface IRespuestaService {
    List<Respuesta> list();
    Respuesta insert(Respuesta r);
    Respuesta listId(int id);
    Respuesta update(Respuesta r);
    void delete(int id);
    List<Respuesta> BuscarporAsunto(String asunto);
    List<Respuesta> Buscarporfecha();
}