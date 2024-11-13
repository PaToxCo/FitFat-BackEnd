package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.AlimentosDTO;
import pe.edu.upc.fitfat.dtos.TotalAlimentosDTO;
import pe.edu.upc.fitfat.dtos.TotalCaloriasDTO;
import pe.edu.upc.fitfat.entities.Alimentos;
import pe.edu.upc.fitfat.serviceinterfaces.IAlimentosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alimentos")
@PreAuthorize("hasAuthority('USER')")

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
    @GetMapping("/total-alimentos")
    public List<TotalAlimentosDTO> totalAlimentos() {
        List<String[]> lista = aS.countAlimentosByDieta();
        List<TotalAlimentosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            TotalAlimentosDTO dto = new TotalAlimentosDTO();
            dto.setDieta(columna[0]);
            dto.setTotalAlimentos(Long.parseLong(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/total-calorias")
    public List<TotalCaloriasDTO> totalCalorias() {
        List<String[]> lista = aS.sumCaloriasByDieta();
        List<TotalCaloriasDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            TotalCaloriasDTO dto = new TotalCaloriasDTO();
            dto.setDieta(columna[0]);
            dto.setTotalCalorias(Long.parseLong(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
