package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.DescripcionLengthDTO;
import pe.edu.upc.fitfat.dtos.RecetaCountDTO;
import pe.edu.upc.fitfat.dtos.RecetaDTO;
import pe.edu.upc.fitfat.entities.Receta;
import pe.edu.upc.fitfat.serviceinterfaces.IRecetaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recetas")
@PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('ADMIN')")

public class RecetaController {

    @Autowired
    private IRecetaService rS;

    @GetMapping
    public List<RecetaDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RecetaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta receta = m.map(dto, Receta.class);
        rS.insert(receta);
    }

    @GetMapping("/{id}")
    public RecetaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), RecetaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RecetaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta receta = m.map(dto, Receta.class);
        rS.update(receta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }
    @GetMapping("/buscar")
    public List<RecetaDTO> buscarPorNombreYUsuario(@RequestParam String nombre, @RequestParam int idUsuario) {
        return rS.searchRecetasByNombreAndUsuario(nombre, idUsuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/countByComida")
    public List<RecetaCountDTO> countRecetasByComida() {
        List<String[]> lista = rS.countRecetasByComida();
        List<RecetaCountDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            RecetaCountDTO dto = new RecetaCountDTO();
            dto.setComidaId(columna[0]);
            dto.setTotalRecetas(Long.parseLong(columna[1]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }

    @GetMapping("/sumDescripcionLengthByComida")
    public List<DescripcionLengthDTO> sumDescripcionLengthByComida() {
        List<String[]> lista = rS.sumDescripcionLengthByComida();
        List<DescripcionLengthDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            DescripcionLengthDTO dto = new DescripcionLengthDTO();
            dto.setComidaId(columna[0]);
            dto.setTotalDescripcionLength(Long.parseLong(columna[1]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }

}
