package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.DietaDTO;
import pe.edu.upc.fitfat.entities.Dieta;
import pe.edu.upc.fitfat.serviceinterfaces.IDietaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dietas")
public class DietaController {

    @Autowired
    private IDietaService dS;

    @GetMapping
    public List<DietaDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DietaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DietaDTO dto) {
        ModelMapper m = new ModelMapper();
        Dieta dieta = m.map(dto, Dieta.class);
        dS.insert(dieta);
    }

    @GetMapping("/{id}")
    public DietaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(dS.listId(id), DietaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody DietaDTO dto) {
        ModelMapper m = new ModelMapper();
        Dieta dieta = m.map(dto, Dieta.class);
        dS.update(dieta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dS.delete(id);
    }
    @GetMapping("/buscarPorNombre")
    public List<DietaDTO> buscardietapornombre(@RequestParam("nombre") String nombre) {
        return dS.buscardietapornombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DietaDTO.class);
        }).collect(Collectors.toList());
    }
}
