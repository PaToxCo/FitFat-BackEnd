package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ControlDTO;
import pe.edu.upc.fitfat.entities.Control;
import pe.edu.upc.fitfat.serviceinterfaces.IControlService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/control")
public class ControlController {

    @Autowired
    private IControlService cS;

    @GetMapping
    public List<ControlDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ControlDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ControlDTO dto) {
        ModelMapper m = new ModelMapper();
        Control control = m.map(dto, Control.class);
        cS.insert(control);
    }

    @GetMapping("/{id}")
    public ControlDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.listId(id), ControlDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ControlDTO dto) {
        ModelMapper m = new ModelMapper();
        Control control = m.map(dto, Control.class);
        cS.update(control);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @GetMapping("/filtrarPorFecha")
    public List<ControlDTO> filtrarPorFecha(@RequestParam Date fecha) {
        return cS.filtrarPorFecha(fecha).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ControlDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/ultimoControlPorNombre")
    public ControlDTO obtenerUltimoControlPorNombreUsuario(@RequestParam String nombre) {
        Control control = cS.obtenerUltimoControlPorNombreUsuario(nombre);
        if (control != null) {
            ModelMapper m = new ModelMapper();
            return m.map(control, ControlDTO.class);
        }
        return null; // O lanzar una excepción según tu preferencia
    }
}
