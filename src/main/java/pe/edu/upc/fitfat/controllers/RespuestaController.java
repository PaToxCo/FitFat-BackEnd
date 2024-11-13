package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.RespuestaDTO;
import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.entities.Respuesta;
import pe.edu.upc.fitfat.serviceinterfaces.IComidaService;
import pe.edu.upc.fitfat.serviceinterfaces.IRespuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuesta")
@PreAuthorize("hasAuthority('ADMIN')")

public class RespuestaController {
    @Autowired
    private IRespuestaService respuestaService;

    @GetMapping
    public List<RespuestaDTO> listar() {
        return respuestaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        Respuesta respuesta = m.map(dto, Respuesta.class);
        respuestaService.insert(respuesta);
    }

    @GetMapping("/{id}")
    public RespuestaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(respuestaService.listId(id), RespuestaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        Respuesta respuesta = m.map(dto, Respuesta.class);
        respuestaService.update(respuesta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        respuestaService.delete(id);
    }
}