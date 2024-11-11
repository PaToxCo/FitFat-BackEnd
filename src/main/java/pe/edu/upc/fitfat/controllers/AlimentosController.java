package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.AlimentosDTO;
import pe.edu.upc.fitfat.entities.Alimentos;
import pe.edu.upc.fitfat.serviceinterfaces.IAlimentosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alimentos")
public class AlimentosController {

    @Autowired
    private IAlimentosService aS;

    @GetMapping
    public List<AlimentosDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlimentosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody AlimentosDTO dto) {
        ModelMapper m = new ModelMapper();
        Alimentos alimentos = m.map(dto, Alimentos.class);
        aS.insert(alimentos);
    }

    @GetMapping("/{id}")
    public AlimentosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(aS.listId(id), AlimentosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody AlimentosDTO dto) {
        ModelMapper m = new ModelMapper();
        Alimentos alimentos = m.map(dto, Alimentos.class);
        aS.update(alimentos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.delete(id);
    }

    @GetMapping("/by-usuario")
    public List<AlimentosDTO> filtrarPorUsuarioId(@RequestParam("usuarioId") int usuarioId) {
        return aS.filtrarPorUsuarioId(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlimentosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/search")
    public List<Alimentos> searchAlimentos(@RequestParam("nombre") String nombre, @RequestParam("usuarioId") int usuarioId) {
        return aS.findAlimentosByNombreAndUsuario(nombre, usuarioId);
    }
}
