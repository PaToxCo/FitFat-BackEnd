package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ConsultaDTO;
import pe.edu.upc.fitfat.entities.Consulta;
import pe.edu.upc.fitfat.serviceinterfaces.IConsultaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private IConsultaService conS;

    @GetMapping
    public List<ConsultaDTO> listar() {
        return conS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta v = m.map(dto, Consulta.class);
        conS.insert(v);
    }

    @GetMapping("/{id}")
    public ConsultaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(conS.listId(id), ConsultaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta v = m.map(dto, Consulta.class);
        conS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        conS.delete(id);
    }

    @GetMapping("/buscarFecha")
    public List<ConsultaDTO> buscar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaConsulta) {
        return conS.buscarFechaConsulta(fechaConsulta).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultaDTO.class);
        }).collect(Collectors.toList());
    }
}
