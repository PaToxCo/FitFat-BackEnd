package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ComidaDTO;
import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.serviceinterfaces.IComidaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    private IComidaService cS;

    @GetMapping
    public List<ComidaDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComidaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ComidaDTO dto) {
        ModelMapper m = new ModelMapper();
        Comida comida = m.map(dto, Comida.class);
        cS.insert(comida);
    }

    @GetMapping("/{id}")
    public ComidaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.listId(id), ComidaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ComidaDTO dto) {
        ModelMapper m = new ModelMapper();
        Comida comida = m.map(dto, Comida.class);
        cS.update(comida);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @GetMapping("/favorites")
    public List<Comida> getFavoriteComidas(@RequestParam("usuarioId") int usuarioId) {
        return cS.findFavoriteComidas(usuarioId);
    }

    @GetMapping("/calorias")
    public Comida getComidaWithMostCalories(@RequestParam int idUsuario) {
        return cS.findComidaWithMostCalories(idUsuario);
    }

    @GetMapping("/search")
    public List<Comida> searchComidaByName(@RequestParam("nombre") String nombre) {
        return cS.searchComidaByName(nombre);
    }
}
