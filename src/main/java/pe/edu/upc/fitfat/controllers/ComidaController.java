package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ComidaDTO;
import pe.edu.upc.fitfat.dtos.ComidaFavoritaPorTipoDTO;
import pe.edu.upc.fitfat.dtos.SumaCaloriasPorUsuarioDTO;
import pe.edu.upc.fitfat.entities.Comida;
import pe.edu.upc.fitfat.serviceinterfaces.IComidaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comidas")
@PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('ADMIN')")

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

    @GetMapping("/cantidad-favoritas-tipo")
    public List<ComidaFavoritaPorTipoDTO> cantidadComidasFavoritasPorTipo() {
        List<String[]> lista = cS.cantidadComidasFavoritasPorTipo();
        List<ComidaFavoritaPorTipoDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            ComidaFavoritaPorTipoDTO dto = new ComidaFavoritaPorTipoDTO();
            dto.setNombreTipoComida(columna[0]);
            dto.setCantidadComidasFavoritas(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/suma-calorias-usuario")
    public List<SumaCaloriasPorUsuarioDTO> sumaCaloriasPorUsuario() {
        List<String[]> lista = cS.sumaCaloriasPorUsuario();
        List<SumaCaloriasPorUsuarioDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            SumaCaloriasPorUsuarioDTO dto = new SumaCaloriasPorUsuarioDTO();
            dto.setNombreUsuario(columna[0]);
            dto.setSumaCalorias(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
