package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ObjetivosDTO;
import pe.edu.upc.fitfat.entities.Objetivos;
import pe.edu.upc.fitfat.serviceinterfaces.IObjetivosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {

    @Autowired
    private IObjetivosService oS;

    @GetMapping
    public List<ObjetivosDTO> listar() {
        return oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos obj = m.map(dto, Objetivos.class);
        oS.insert(obj);
    }

    @GetMapping("/{id}")
    public ObjetivosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(oS.listId(id), ObjetivosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos obj = m.map(dto, Objetivos.class);
        oS.update(obj);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        oS.delete(id);
    }

    @GetMapping("/buscarPorEstado")
    public List<ObjetivosDTO> buscarPorEstado(@RequestParam("estado") String estado) {
        return oS.buscarPorEstado(estado).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarPorTipoObjetivo")
    public List<ObjetivosDTO> buscarPorTipoObjetivo(@RequestParam("tipo_objetivo") String tipo_objetivo) {
        return oS.buscarPorTipoObjetivo(tipo_objetivo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosDTO.class);
        }).collect(Collectors.toList());
    }
}
