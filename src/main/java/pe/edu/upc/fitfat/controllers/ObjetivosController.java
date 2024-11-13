package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.DuracionObjetivosPorTipoDTO;
import pe.edu.upc.fitfat.dtos.FechasObjetivosPorEstadoDTO;
import pe.edu.upc.fitfat.dtos.ObjetivosDTO;
import pe.edu.upc.fitfat.entities.Objetivos;
import pe.edu.upc.fitfat.serviceinterfaces.IObjetivosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
@PreAuthorize("hasAuthority('USER')")

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

    @GetMapping("/fechas-por-estado")
    public List<FechasObjetivosPorEstadoDTO> obtenerFechasPorEstado() {
        List<String[]> lista = oS.obtenerFechasPorEstado();
        List<FechasObjetivosPorEstadoDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            FechasObjetivosPorEstadoDTO dto = new FechasObjetivosPorEstadoDTO();
            dto.setEstado(columna[0]);
            dto.setFecha_inicio_min(LocalDate.parse(columna[1]));
            dto.setFecha_inicio_max(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/duracion-por-tipo")
    public List<DuracionObjetivosPorTipoDTO> obtenerDuracionPorTipoObjetivo() {
        List<String[]> lista = oS.obtenerDuracionPorTipoObjetivo();
        List<DuracionObjetivosPorTipoDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            DuracionObjetivosPorTipoDTO dto = new DuracionObjetivosPorTipoDTO();
            dto.setTipo_objetivo(columna[0]);
            try {
                dto.setDuracion_total(Long.parseLong(columna[1]));
            } catch (NumberFormatException e) {
                dto.setDuracion_total(0L);  // Manejar valores que no se pueden convertir
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
