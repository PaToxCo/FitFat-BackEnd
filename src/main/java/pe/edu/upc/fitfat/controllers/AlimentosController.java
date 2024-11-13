package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.AlimentosDTO;
import pe.edu.upc.fitfat.dtos.CaloriasByAlimentosDTO;
import pe.edu.upc.fitfat.dtos.CarbohidratosByAlimentosDTO;
import pe.edu.upc.fitfat.dtos.GrasasByAlimentosDTO;
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
    @GetMapping("/calorias")
    public List<CaloriasByAlimentosDTO> caloriasAlimento() {
        List<String[]> caloriasByAlimentos = aS.caloriasByAlimentos();
        return caloriasByAlimentos.stream().map(y -> {
            CaloriasByAlimentosDTO dto = new CaloriasByAlimentosDTO();
            dto.setNombre(y[0]);
            dto.setCalorias(Integer.parseInt(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
    @GetMapping("/carbohidratos")
    public List<CarbohidratosByAlimentosDTO> carbohidratosAlimento() {
        List<String[]> carbohidratosByAlimentos = aS.carbohidratosByAlimentos();
        return carbohidratosByAlimentos.stream().map(y -> {
            CarbohidratosByAlimentosDTO dto = new CarbohidratosByAlimentosDTO();
            dto.setNombre(y[0]);
            dto.setCarbohidratos(Double.parseDouble(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
    @GetMapping("/grasas")
    public List<GrasasByAlimentosDTO> grasasAlimento() {
        List<String[]> grasasByAlimento = aS.grasasByAlimentos();
        return grasasByAlimento.stream().map(y -> {
            GrasasByAlimentosDTO dto = new GrasasByAlimentosDTO();
            dto.setNombre(y[0]);
            dto.setGrasas(Double.parseDouble(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
}
