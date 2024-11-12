package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ContarTiposPorCategoriaDTO;
import pe.edu.upc.fitfat.dtos.Tipo_comidaDTO;
import pe.edu.upc.fitfat.entities.Tipo_comida;
import pe.edu.upc.fitfat.serviceinterfaces.ITipo_comidaService;
//pal query
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos-comida")
public class Tipo_comidaController {

    @Autowired
    private ITipo_comidaService tCS;

    @GetMapping
    public List<Tipo_comidaDTO> listar() {
        return tCS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Tipo_comidaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody Tipo_comidaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_comida tipoComida = m.map(dto, Tipo_comida.class);
        tCS.insert(tipoComida);
    }

    @GetMapping("/{id}")
    public Tipo_comidaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(tCS.listId(id), Tipo_comidaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody Tipo_comidaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_comida tipoComida = m.map(dto, Tipo_comida.class);
        tCS.update(tipoComida);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        tCS.delete(id);
    }

    @GetMapping("/frecuencia/{usuarioId}")
    public ResponseEntity<List<Object[]>> findMostFrequentTipoComidaByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        List<Object[]> result = tCS.findMostFrequentTipoComidaByUsuarioId(usuarioId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public List<Tipo_comida> filterByCategory(@RequestParam("categoria") String categoria) {
        return tCS.filterByCategory(categoria);
    }
    @GetMapping("/contar-por-categoria")
    public List<ContarTiposPorCategoriaDTO> contarTiposPorCategoria() {
        List<String[]> resultados = tCS.contarTiposPorCategoria();
        List<ContarTiposPorCategoriaDTO> listaDTO = new ArrayList<>();
        for (String[] columna : resultados) {
            ContarTiposPorCategoriaDTO dto = new ContarTiposPorCategoriaDTO();
            dto.setCategoria(columna[0]);
            dto.setCantidad(Long.parseLong(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
