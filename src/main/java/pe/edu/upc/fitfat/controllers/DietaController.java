package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.DietaDTO;
import pe.edu.upc.fitfat.dtos.DietasPorUsuarioDTO;
import pe.edu.upc.fitfat.dtos.DuracionTotalDietasDTO;
import pe.edu.upc.fitfat.dtos.UsuariosDTO;
import pe.edu.upc.fitfat.entities.Dieta;
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.serviceinterfaces.IDietaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dietas")
@PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('ADMIN')")

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
    @GetMapping("/quantitydiet")
    public List<DietasPorUsuarioDTO> listarCantidadeDieta() {
        List<String[]> cantidadDietas = dS.cantidadDietas();
        return cantidadDietas.stream().map(y -> {
                DietasPorUsuarioDTO dto = new DietasPorUsuarioDTO();
            dto.setIdUsuario(Integer.parseInt(y[0]));
            dto.setCantidad_dietas(Integer.parseInt(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
    @GetMapping("/totalduration")
    public List<DuracionTotalDietasDTO> duracionTotalDietas() {
        List<String[]> duraciontotaldietas = dS.duraciontotaldietas();
        return duraciontotaldietas.stream().map(y -> {
            DuracionTotalDietasDTO dto = new DuracionTotalDietasDTO();
            dto.setId_usuario(Integer.parseInt(y[0]));
            dto.setDuracion(Integer.parseInt(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarPorNombre")
    public List<DietaDTO> buscardietapornombre(@RequestParam("nombre") String nombre) {
        return dS.buscardietapornombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DietaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/me")
    public ResponseEntity<List<DietaDTO>> getDietasByUser() {
        // Obtener el usuario logueado desde el SecurityContextHolder
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        // Obtener los IDs de las dietas asociadas al usuario
        List<String[]> dietasId = dS.findDietIdByUser(username);

        // Convertir los IDs a las dietas completas
        ModelMapper modelMapper = new ModelMapper();
        List<DietaDTO> dietasDTO = dietasId.stream()
                .map(dieta -> {
                    int idDieta = Integer.parseInt(dieta[0]); // Convertir el ID de la dieta a int
                    Dieta dietaEntity = dS.listId(idDieta); // Obtener la dieta completa por ID
                    return modelMapper.map(dietaEntity, DietaDTO.class); // Convertir la entidad Dieta a DTO
                })
                .collect(Collectors.toList());

        // Retornar las dietas del usuario
        return ResponseEntity.ok(dietasDTO);
    }
    @GetMapping("/dietasPorUsuario")
    public List<DietaDTO> findDietasByUser(@RequestParam("usuario") String usuario) {
        // Llamar al servicio para obtener los IDs de las dietas asociadas al usuario
        List<String[]> dietasId = dS.findDietIdByUser(usuario);

        // Convertir los IDs a las dietas completas
        ModelMapper m = new ModelMapper();
        return dietasId.stream()
                .map(dieta -> {
                    int idDieta = Integer.parseInt(dieta[0]); // Convertir el ID de la dieta a int
                    Dieta dietaEntity = dS.listId(idDieta); // Obtener la dieta completa por ID
                    return m.map(dietaEntity, DietaDTO.class); // Convertir la entidad Dieta a DTO
                })
                .collect(Collectors.toList());
    }


}
